package com.memsource.task.service;

import com.memsource.task.domain.User;
import org.springframework.stereotype.Service;

public interface UserQueryService {

    User getUser(Long id);
}
