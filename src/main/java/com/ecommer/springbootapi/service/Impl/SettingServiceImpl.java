package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.dto.request.SettingDto;
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
    public SettingDto addSetting(SettingDto settingDto) {
        Optional<Setting> setting = settingRepository.findAll().stream().findFirst();
        if (!setting.isPresent()) {
            Setting firstSetting = mapToEntity(settingDto);
            Setting save = settingRepository.save(firstSetting);
            return mapToDto(save);
        } else {
            throw new ApiException("Setting already exists, please edit it only", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SettingDto updateSetting(SettingDto settingDto, Long id) {
        Setting setting = settingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Setting", id));
        setting.setTitle(settingDto.getTitle());
        setting.setKeywords(settingDto.getKeywords());
        setting.setDescription(settingDto.getDescription());
        setting.setCompany(settingDto.getCompany());
        setting.setAddress(settingDto.getAddress());
        setting.setPhone(settingDto.getPhone());
        setting.setFax(settingDto.getFax());
        setting.setEmail(settingDto.getEmail());
        setting.setSmtpEmail(settingDto.getSmtpEmail());
        setting.setSmtpPassword(settingDto.getSmtpPassword());
        setting.setSmtpPort(settingDto.getSmtpPort());
        setting.setFacebook(settingDto.getFacebook());
        setting.setInstagram(settingDto.getInstagram());
        setting.setTwitter(settingDto.getTwitter());
        setting.setAboutUs(settingDto.getAboutUs());
        setting.setContact(settingDto.getContact());
        setting.setReference(settingDto.getReference());
        setting.setStatus(settingDto.getStatus());

        settingRepository.save(setting);
        return mapToDto(setting);
    }

    private SettingDto mapToDto(Setting setting) {
        SettingDto settingDto = modelMapper.map(setting, SettingDto.class);
        return settingDto;
    }

    private Setting mapToEntity(SettingDto settingDto) {
        Setting setting = modelMapper.map(settingDto, Setting.class);
        return setting;
    }
}
