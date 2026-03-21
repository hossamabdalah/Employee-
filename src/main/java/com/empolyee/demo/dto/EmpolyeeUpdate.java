package com.empolyee.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record EmpolyeeUpdate(

        @NotBlank
        @Size(min = 2, max = 50)
        String firstName,

        @NotBlank
        @Size(min = 2, max = 50)
        String lastName,

        @NotBlank
        @Size(min = 10, max = 15)
        String phoneNumber,

        @NotNull
        LocalDate hireDate,

        @NotBlank
        @Size(min = 2, max = 100)
        String position,

        @NotNull
        UUID departmentId

) {
}
