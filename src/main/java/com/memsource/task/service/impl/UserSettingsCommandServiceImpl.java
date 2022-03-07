package com.memsource.task.service.impl;

import com.memsource.task.domain.User;
import com.memsource.task.domain.UserSettings;
import com.memsource.task.dto.UserSettingsDTO;
import com.memsource.task.exception.BadRequestException;
import com.memsource.task.repository.UserSettingsRepository;
import com.memsource.task.service.UserSettingsCommandService;
import com.memsource.task.service.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserSettingsCommandServiceImpl implements UserSettingsCommandService {

    @Autowired
    private UserSettingsRepository userSettingsRepository;

    @Override
    public UserSettingsDTO save(UserSettingsDTO userSettingsDTO) {
        Util.validateIdExists(userSettingsDTO.getUserId(), null);

        if (Util.isNullOrEmpty(userSettingsDTO.getPassword())) {
            throw new BadRequestException("Password cannot be empty");
        }

        UserSettings userSettings = userSettingsRepository.findOneByUserId(userSettingsDTO.getUserId()).orElse(new UserSettings());

        userSettings.setPassword(userSettingsDTO.getPassword());

        UserSettings savedData = userSettingsRepository.save(userSettings);
        return savedData.toDTO();
    }
}
