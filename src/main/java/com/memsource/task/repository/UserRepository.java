package com.memsource.task.repository;

import com.memsource.task.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findOneByUserName(String userName);
}
