package com.empolyee.demo.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ApiError {

    private final LocalDateTime timestamp;
    private final int status;
    private final List<ErrorItem> errors;

    public ApiError(int status, List<ErrorItem> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.errors = errors;
    }

    @Getter
    @AllArgsConstructor
    public static class ErrorItem {
        private String message;
    }
}
