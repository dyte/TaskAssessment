package com.memsource.task.service;

import com.memsource.task.dto.UserSettingsDTO;

public interface UserSettingsCommandService {

    UserSettingsDTO save(UserSettingsDTO userSettingsDTO);
}
