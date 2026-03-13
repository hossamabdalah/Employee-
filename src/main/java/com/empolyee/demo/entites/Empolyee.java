package com.empolyee.demo.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
public class Empolyee {
    private UUID id;
    private String firstName;
    private String lastName;
    private String emaill;
    private String phoneNumber;
    private LocalDate hireDate;
    private String position;
    private UUID departmentId;
}
