package com.ecommer.springbootapi.service;

import com.ecommer.springbootapi.dto.request.SettingRequest;

public interface SettingService {
    SettingRequest addSetting(SettingRequest settingRequest);

    SettingRequest updateSetting(SettingRequest settingRequest, Long id);
}
