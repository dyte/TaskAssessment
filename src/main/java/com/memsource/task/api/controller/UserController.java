package com.memsource.task.api.controller;

import com.memsource.task.domain.User;
import com.memsource.task.dto.UserDTO;
import com.memsource.task.service.UserCommandService;
import com.memsource.task.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8", consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserQueryService userQueryService;

    @Autowired
    private UserCommandService userCommandService;

    @GetMapping(value = "/users/{id}", consumes = MediaType.ALL_VALUE)
    private User getUserById(@PathVariable("id") long id) {
        return userQueryService.getUser(id);
    }

    @PostMapping(value = "/users")
    public UserDTO createUser(@RequestBody UserDTO user) {
        return userCommandService.create(user);
    }
}
