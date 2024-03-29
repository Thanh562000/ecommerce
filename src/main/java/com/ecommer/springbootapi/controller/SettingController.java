package com.ecommer.springbootapi.controller;

import com.ecommer.springbootapi.dto.request.SettingDto;
import com.ecommer.springbootapi.entities.Setting;
import com.ecommer.springbootapi.repository.SettingRepository;
import com.ecommer.springbootapi.service.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/setting")
@RequiredArgsConstructor
public class SettingController {
    private final SettingService settingService;

    private final SettingRepository settingRepository;

    @PostMapping("/create")
    public ResponseEntity<SettingDto> create(@RequestBody SettingDto settingDto) {
        SettingDto createSetting = settingService.addSetting(settingDto);
        return new ResponseEntity<>(createSetting, HttpStatus.CREATED);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<SettingDto> edit(@RequestBody SettingDto settingDto) {
        Optional<Setting> existingSetting = settingRepository.findAll().stream().findFirst();
        return ResponseEntity.ok(settingService.updateSetting(settingDto, existingSetting.get().getId()));
    }
}
