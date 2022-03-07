package com.memsource.task.exception;

import lombok.Getter;

@Getter
public enum MemsourceExceptionMessages {

    OBJECT_MAPPING_ERROR("An error occurred during object mapping operations"),
    ID_MUST_BE_EMPTY("Id field must be null or empty to create a new data"),
    USER_NAME_ALREADY_EXISTS("User name already taken for another user")
    ;

    private String message;

    MemsourceExceptionMessages(String message) {
        this.message = message;
    }
}
