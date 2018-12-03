package com.dream.itup.web.exception;

public class TaskIdMismatchException extends RuntimeException {

    public TaskIdMismatchException() {
        super();
    }

    public TaskIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TaskIdMismatchException(final String message) {
        super(message);
    }

    public TaskIdMismatchException(final Throwable cause) {
        super(cause);
    }
}