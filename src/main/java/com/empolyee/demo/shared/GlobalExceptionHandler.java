package com.empolyee.demo.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex) {
        List<ApiError.ErrorItem> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> new ApiError.ErrorItem(err.getField() + ": " + err.getDefaultMessage()))
                .toList();

        ApiError response = new ApiError(400, errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException ex) {
        var errors = List.of(new ApiError.ErrorItem(ex.getMessage()));
        ApiError response = new ApiError(404, errors);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ApiError> handleConflict(ConflictException ex) {
        var errors = List.of(new ApiError.ErrorItem(ex.getMessage()));
        ApiError response = new ApiError(409, errors);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiError> handleBadCredentials(BadCredentialsException ex) {
        var errors = List.of(new ApiError.ErrorItem(ex.getMessage()));
        ApiError response = new ApiError(401, errors);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(Exception ex) {
        var errors = List.of(new ApiError.ErrorItem("Internal server error"));
        ApiError response = new ApiError(500, errors);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}