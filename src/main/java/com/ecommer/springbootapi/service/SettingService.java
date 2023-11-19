package com.ecommer.springbootapi.service;

import com.ecommer.springbootapi.dto.request.SettingDto;

public interface SettingService {
    SettingDto addSetting(SettingDto settingDto);

    SettingDto updateSetting(SettingDto settingDto, Long id);
}
