package com.memsource.task.service.impl;

import com.memsource.task.domain.User;
import com.memsource.task.repository.UserRepository;
import com.memsource.task.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserQueryServiceImpl implements UserQueryService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
