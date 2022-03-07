package com.memsource.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class MemsourceException extends RuntimeException {

    public MemsourceException (String message) {
        super(message);
    }

    public MemsourceException (String message, Throwable cause) {
        super(message, cause);
    }
}
