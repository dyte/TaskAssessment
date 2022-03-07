package com.memsource.task.service.impl;

import com.memsource.task.domain.UserSettings;
import com.memsource.task.dto.UserSettingsDTO;
import com.memsource.task.repository.UserSettingsRepository;
import com.memsource.task.service.UserSettingsQueryService;
import com.memsource.task.service.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserSettingsQueryServiceImpl implements UserSettingsQueryService {

    @Autowired
    private UserSettingsRepository userSettingsRepository;

    @Override
    public UserSettingsDTO getUserSettingsById(Long id) {
        Util.validateIdExists(id, "Invalid data: ID not found");

        UserSettings userSettings = userSettingsRepository.findById(id).orElse(null);
        return validateAndReturnUserSettings(userSettings);
    }

    @Override
    public UserSettingsDTO getUserSettingsByUserId(Long userId) {
        Util.validateIdExists(userId, "Invalid data: User ID not found");

        UserSettings userSettings = userSettingsRepository.findOneByUserId(userId).orElse(new UserSettings());
        return validateAndReturnUserSettings(userSettings);
    }

    private UserSettingsDTO validateAndReturnUserSettings(UserSettings userSettings) {
        Util.validateResponseEntity(userSettings, "UserSettings cannot be found");
        return userSettings.toDTO();
    }
}
