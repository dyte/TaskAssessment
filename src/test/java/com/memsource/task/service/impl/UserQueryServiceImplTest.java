package com.memsource.task.service.impl;

import com.memsource.task.domain.User;
import com.memsource.task.dto.UserDTO;
import com.memsource.task.repository.UserRepository;
import com.memsource.task.testbase.UserDataFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class UserQueryServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private UserQueryServiceImpl userQueryService;

    @Test
    public void getUserByIdSuccessfullyTest() {

        User expectedUser = UserDataFactory.generateUser("Name", "Surname");
        expectedUser.setDeleted(false);
        expectedUser.setId(1L);
        expectedUser.setCreateDate(LocalDateTime.now());
        expectedUser.setUpdateDate(LocalDateTime.now());

        Optional<User> optionalUser = Optional.of(expectedUser);
        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(optionalUser);

        User actualUser = userQueryService.getUser(1L);

        assertNotNull(actualUser);
        assertEquals(expectedUser.toString(), actualUser.toString());
    }

}