package com.memsource.task.service.impl;

import com.memsource.task.domain.User;
import com.memsource.task.dto.UserDTO;
import com.memsource.task.exception.BadRequestException;
import com.memsource.task.exception.MemsourceException;
import com.memsource.task.exception.MemsourceExceptionMessages;
import com.memsource.task.repository.UserRepository;
import com.memsource.task.service.UserCommandService;
import com.memsource.task.service.Util;
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

        Util.validateIdForCreate(user.getId(), MemsourceExceptionMessages.ID_MUST_BE_EMPTY.getMessage());

        User validateUser = userRepository.findOneByUserName(userDTO.getUserName()).orElse(null);
        if (validateUser != null) {
            throw new MemsourceException("User already exists");
        }

        return userRepository.save(user).toDTO();
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        Util.validateIdExists(userDTO.getId(), null);

        if (Util.isNullOrEmpty(userDTO.getName())) {
            throw new BadRequestException("Name field is required");
        } else if (Util.isNullOrEmpty(userDTO.getSurName())) {
            throw new BadRequestException("Sur name field is required");
        } else if (Util.isNullOrEmpty(userDTO.getUserName())) {
            throw new BadRequestException("User name field is required");
        }
        User updateUser = userRepository.findOneByUserName(userDTO.getUserName()).orElse(null);
        Util.validateResponseEntity(updateUser, "User could not be found for update");

        if (!userDTO.getId().equals(updateUser.getId())) {
            throw new MemsourceException(MemsourceExceptionMessages.USER_NAME_ALREADY_EXISTS.getMessage());
        }

        updateUser.setName(userDTO.getName());
        updateUser.setSurName(userDTO.getSurName());
        updateUser.setUserName(userDTO.getUserName());

        return userRepository.save(updateUser).toDTO();
    }
}
