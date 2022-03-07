package com.memsource.task.domain;

import com.memsource.task.dto.UserDTO;
import com.memsource.task.testbase.UserDataFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void validateTwoInstances() {
        User user1 = UserDataFactory.generateUser("Name1", "Surname1", "UserName1");
        User user2 = UserDataFactory.generateUser("Name1", "Surname1", "UserName1");


        assertEquals(user1.toString(), user2.toString());
        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void validateToDTO() {
        User user = UserDataFactory.generateUser("Name1", "Surname1", "UserName1");
        UserDTO userDTO = user.toDTO();

        assertNotNull(user);
        assertNotNull(userDTO);


        assertEquals(user.getName(), userDTO.getName());

        UserDTO actualDTO = UserDataFactory.generateUserDTO(null,"Name1", "Surname1", "UserName1");
        assertEquals(userDTO.getName(), actualDTO.getName());
        assertEquals(userDTO.getSurName(), actualDTO.getSurName());
        assertEquals(userDTO.getId(), actualDTO.getId());

        assertEquals(userDTO.toString(), actualDTO.toString());


    }
}