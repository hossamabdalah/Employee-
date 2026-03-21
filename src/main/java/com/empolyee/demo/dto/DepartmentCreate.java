package com.empolyee.demo.dto;

import jakarta.validation.constraints.NotNull;

public record DepartmentCreate(
        @NotNull
        String name
) {
}
