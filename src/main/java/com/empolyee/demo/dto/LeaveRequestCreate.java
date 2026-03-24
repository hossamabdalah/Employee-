package com.empolyee.demo.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record LeaveRequestCreate(
        @NotNull
        @FutureOrPresent(message = "start date must be presnt or in future")
        LocalDate startDate,
        @NotNull
        @FutureOrPresent(message = "end date must be presnt or in future")
        LocalDate endDate,


        @NotBlank
        String reason


) {
}
