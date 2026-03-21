package com.empolyee.demo.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empolyee {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UuidGenerator
    private UUID id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)

    private String lastName;
    @Column(name = "email", nullable = false, unique = true)

    private String email;
    @Column(name = "phone_number", nullable = false)

    private String phoneNumber;
    @Column(name = "hire_date", nullable = false)

    private LocalDate hireDate;
    @Column(name = "position", nullable = false)

    private String position;
    @Column(name = "departmentId", nullable = false)
//    @UuidGenerator
    private UUID departmentId;
}
