package com.memsource.task.testbase;

import com.memsource.task.domain.User;
import com.memsource.task.dto.UserDTO;

public class UserDataFactory {

    public static User generateUser(String name, String surName, String userName) {
        return new User(name, surName, userName);
    }

    public static UserDTO generateUserDTO(Long id, String name, String surName, String userName) {
        UserDTO userDTO = new UserDTO(name, surName, userName);
        userDTO.setId(id);
        return userDTO;
    }
}
