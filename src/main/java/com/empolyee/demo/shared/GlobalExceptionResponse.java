package com.empolyee.demo.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionResponse {
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Test> handlenotFoundException(NoResourceFoundException ex){
        return new ResponseEntity<>(new Test("Custome Error"), HttpStatus.NOT_FOUND);
    }
}
@AllArgsConstructor
@Getter
@Setter
class Test{
    private String message;
}
