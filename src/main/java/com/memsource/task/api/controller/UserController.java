package com.memsource.task.api.controller;

import com.memsource.task.domain.User;
import com.memsource.task.dto.UserDTO;
import com.memsource.task.dto.UserSettingsDTO;
import com.memsource.task.service.UserCommandService;
import com.memsource.task.service.UserQueryService;
import com.memsource.task.service.UserSettingsCommandService;
import com.memsource.task.service.UserSettingsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8", consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserQueryService userQueryService;

    @Autowired
    private UserCommandService userCommandService;

    @Autowired
    private UserSettingsQueryService userSettingsQueryService;

    @Autowired
    private UserSettingsCommandService userSettingsCommandService;

    @GetMapping(value = "/users/{id}", consumes = MediaType.ALL_VALUE)
    private ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        return new ResponseEntity<>(userQueryService.getUser(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        return new ResponseEntity<>(userCommandService.create(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/users")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user) {
        return new ResponseEntity<>(userCommandService.create(user), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}/settings", consumes = MediaType.ALL_VALUE)
    private ResponseEntity<UserSettingsDTO> getUserSettingsByUserId(@PathVariable("id") long userId) {
        return new ResponseEntity<>(userSettingsQueryService.getUserSettingsByUserId(userId), HttpStatus.OK);
    }

    @PutMapping(value = "/users/{id}/settings")
    public ResponseEntity<UserSettingsDTO> updateUserSettings(@RequestBody UserSettingsDTO userSettings) {
        return new ResponseEntity<>(userSettingsCommandService.save(userSettings), HttpStatus.OK);
    }
}
