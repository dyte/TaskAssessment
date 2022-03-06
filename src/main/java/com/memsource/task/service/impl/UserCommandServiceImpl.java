package com.memsource.task.service.impl;

import com.memsource.task.domain.User;
import com.memsource.task.dto.UserDTO;
import com.memsource.task.exception.MemsourceException;
import com.memsource.task.exception.MemsourceExceptionMessages;
import com.memsource.task.repository.UserRepository;
import com.memsource.task.service.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserCommandServiceImpl implements UserCommandService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = new User().fromDTO(userDTO);

        if (user.getId() != null && user.getId() > 0) {
            throw new MemsourceException(MemsourceExceptionMessages.ID_MUST_BE_EMPTY.getMessage());
        }

        return userRepository.save(user).toDTO();
    }
}
