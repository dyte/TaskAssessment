package com.memsource.task.service;

import com.memsource.task.dto.UserSettingsDTO;

public interface UserSettingsQueryService {

    UserSettingsDTO getUserSettingsById(Long id);

    UserSettingsDTO getUserSettingsByUserId(Long userId);
}
