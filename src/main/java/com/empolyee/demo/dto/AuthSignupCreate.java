package com.empolyee.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record AuthSignupCreate(
        @NotBlank(message = "first name is required")
        @Size(min = 2, max = 50)
        String firstName,
        @NotBlank
        String password,

        @NotBlank

        UUID employeeId

) {
}
