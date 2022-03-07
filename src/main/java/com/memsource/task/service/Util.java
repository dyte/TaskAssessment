package com.memsource.task.service;

import com.memsource.task.exception.BadRequestException;
import com.memsource.task.exception.ElementNotFoundException;

public abstract class Util {

    public static void validateResponseEntity(Object responseEntity, String message) {
        if (responseEntity == null) {
            String exMessage = isNullOrEmpty(message) ? "Data cannot be found" : message;
            throw new ElementNotFoundException(exMessage);
        }
    }

    public static void validateIdExists(Long id, String message) {
        if(isNullOrEmpty(id)) {
            String exMessage = isNullOrEmpty(message) ? "Invalid ID value for update" : message;
            throw new BadRequestException(exMessage);
        }
    }

    public static void validateIdForCreate(Long id, String message) {
        if(!isNullOrEmpty(id)) {
            String exMessage = isNullOrEmpty(message) ? "Invalid ID value for create" : message;
            throw new BadRequestException(exMessage);
        }
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNullOrEmpty(Long value) {
        return value == null || value <= 0;
    }
}
