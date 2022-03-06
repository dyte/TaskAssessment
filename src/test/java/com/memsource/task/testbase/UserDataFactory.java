package com.memsource.task.testbase;

import com.memsource.task.domain.User;
import com.memsource.task.dto.UserDTO;

public class UserDataFactory {

    public static User generateUser(String name, String surname) {
        return new User(name, surname);
    }

    public static UserDTO generateUserDTO(String name, String surname) {
        return new UserDTO(name, surname);
    }
}
