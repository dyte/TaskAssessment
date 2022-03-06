package com.memsource.task.service;

import com.memsource.task.dto.UserDTO;

public interface UserCommandService {

    UserDTO create(UserDTO userDTO);
}
