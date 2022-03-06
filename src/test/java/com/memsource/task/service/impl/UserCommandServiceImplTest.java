package com.memsource.task.service.impl;

import com.memsource.task.domain.User;
import com.memsource.task.dto.UserDTO;
import com.memsource.task.repository.UserRepository;
import com.memsource.task.testbase.UserDataFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
    public void createTest() {
        UserDTO userDTO = UserDataFactory.generateUserDTO("Name1", "Surname1");

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

}