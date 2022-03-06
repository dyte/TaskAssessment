package com.memsource.task.exception;

public class MemsourceException extends RuntimeException {

    public MemsourceException () {
        super();
    }

    public MemsourceException (String message) {
        super(message);
    }

    public MemsourceException (String message, Throwable cause) {
        super(message, cause);
    }

    protected MemsourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
