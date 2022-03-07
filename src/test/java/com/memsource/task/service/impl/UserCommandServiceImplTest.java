package com.memsource.task.service.impl;

import com.memsource.task.domain.User;
import com.memsource.task.dto.UserDTO;
import com.memsource.task.exception.BadRequestException;
import com.memsource.task.repository.UserRepository;
import com.memsource.task.testbase.UserDataFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserCommandServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private UserCommandServiceImpl userCommandService;

    @Test
    public void createTest_Successful() {
        UserDTO userDTO = UserDataFactory.generateUserDTO(null,"Name1", "Surname1", "UserName1");

        User expectedUser = new User().fromDTO(userDTO);

        expectedUser.setId(1L);
        expectedUser.setName("Name1");
        expectedUser.setSurName("Surname1");
        expectedUser.setDeleted(false);

        UserDTO expectedUserDTO = expectedUser.toDTO();
        Mockito.when(userRepository.save(any(User.class))).thenReturn(expectedUser);

        UserDTO actualUserDTO = userCommandService.create(userDTO);
        assertNotNull(actualUserDTO);

        assertEquals(expectedUserDTO.getName(), actualUserDTO.getName());
        assertEquals(expectedUserDTO.getSurName(), actualUserDTO.getSurName());

        assertNull(userDTO.getId());
        assertNotNull(expectedUserDTO.getId());
        assertNotNull(actualUserDTO.getId());
        assertEquals(expectedUserDTO.getId(), actualUserDTO.getId());

    }

    @Test
    public void updateTest_Successful() {
        UserDTO userDTO = UserDataFactory.generateUserDTO(1L,"Name1Updated", "Surname1Updated", "UserName1Updated");

        User expectedUser = new User().fromDTO(userDTO);

        expectedUser.setId(1L);
        expectedUser.setName("Name1Updated");
        expectedUser.setSurName("Surname1Updated");
        expectedUser.setUserName("UserName1Updated");
        expectedUser.setDeleted(false);

        Optional<User> optionalUser = Optional.of(expectedUser);

        UserDTO expectedUserDTO = expectedUser.toDTO();
        Mockito.when(userRepository.findOneByUserName(any(String.class))).thenReturn(optionalUser);
        Mockito.when(userRepository.save(any(User.class))).thenReturn(expectedUser);

        UserDTO actualUserDTO = userCommandService.update(userDTO);
        assertNotNull(actualUserDTO);

        assertEquals(expectedUserDTO.getName(), actualUserDTO.getName());
        assertEquals(expectedUserDTO.getSurName(), actualUserDTO.getSurName());

        assertNotNull(userDTO.getId());
        assertNotNull(expectedUserDTO.getId());
        assertNotNull(actualUserDTO.getId());
        assertEquals(expectedUserDTO.getId(), actualUserDTO.getId());

    }

    @Test
    public void updateTest_InvalidUserName() {
        UserDTO userDTO = UserDataFactory.generateUserDTO(1L,"Name1", "Surname1", "");


        Exception exception = assertThrows(BadRequestException.class, () -> {
            userCommandService.update(userDTO);
        });

        String expectedMessage = "User name field is required";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void updateTest_InvalidName() {
        UserDTO userDTO = UserDataFactory.generateUserDTO(1L,"", "Surname1", "UserName1");


        Exception exception = assertThrows(BadRequestException.class, () -> {
            userCommandService.update(userDTO);
        });

        String expectedMessage = "Name field is required";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void updateTest_InvalidSurName() {
        UserDTO userDTO = UserDataFactory.generateUserDTO(1L,"Name1", "", "UserName1");


        Exception exception = assertThrows(BadRequestException.class, () -> {
            userCommandService.update(userDTO);
        });

        String expectedMessage = "Sur name field is required";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void updateTest_InvalidId() {
        UserDTO userDTO = UserDataFactory.generateUserDTO(null,"Name1", "", "UserName1");


        Exception exception = assertThrows(BadRequestException.class, () -> {
            userCommandService.update(userDTO);
        });

        String expectedMessage = "Invalid ID value for update";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}