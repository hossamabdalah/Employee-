package com.empolyee.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record AuthLogin(
        @NotBlank(message = "userName is required")
        @Size(min = 2, max = 50)
        String email,
        @NotBlank
        String password,
        UUID empolyeeId

) {
}
