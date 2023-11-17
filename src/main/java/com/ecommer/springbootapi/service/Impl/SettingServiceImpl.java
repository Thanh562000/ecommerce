package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.dto.request.SettingRequest;
import com.ecommer.springbootapi.entities.Setting;
import com.ecommer.springbootapi.exception.ApiException;
import com.ecommer.springbootapi.exception.ResourceNotFoundException;
import com.ecommer.springbootapi.repository.SettingRepository;
import com.ecommer.springbootapi.service.SettingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettingServiceImpl implements SettingService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SettingRepository settingRepository;

    @Override
    public SettingRequest addSetting(SettingRequest settingRequest) {
        Optional<Setting> setting = settingRepository.findAll().stream().findFirst();
        if (!setting.isPresent()) {
            Setting firstSetting = mapToEntity(settingRequest);
            Setting save = settingRepository.save(firstSetting);
            return mapToDto(save);
        } else {
            throw new ApiException("Setting already exists, please edit it only", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SettingRequest updateSetting(SettingRequest settingRequest, Long id) {
        Setting setting = settingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Setting", id));
        setting.setTitle(settingRequest.getTitle());
        setting.setKeywords(settingRequest.getKeywords());
        setting.setDescription(settingRequest.getDescription());
        setting.setCompany(settingRequest.getCompany());
        setting.setAddress(settingRequest.getAddress());
        setting.setPhone(settingRequest.getPhone());
        setting.setFax(settingRequest.getFax());
        setting.setEmail(settingRequest.getEmail());
        setting.setSmtpEmail(settingRequest.getSmtpEmail());
        setting.setSmtpPassword(settingRequest.getSmtpPassword());
        setting.setSmtpPort(settingRequest.getSmtpPort());
        setting.setFacebook(settingRequest.getFacebook());
        setting.setInstagram(settingRequest.getInstagram());
        setting.setTwitter(settingRequest.getTwitter());
        setting.setAboutUs(settingRequest.getAboutUs());
        setting.setContact(settingRequest.getContact());
        setting.setReference(settingRequest.getReference());
        setting.setStatus(settingRequest.getStatus());

        settingRepository.save(setting);
        return mapToDto(setting);
    }

    private SettingRequest mapToDto(Setting setting) {
        SettingRequest settingRequest = modelMapper.map(setting, SettingRequest.class);
        return settingRequest;
    }

    private Setting mapToEntity(SettingRequest settingRequest) {
        Setting setting = modelMapper.map(settingRequest, Setting.class);
        return setting;
    }
}
