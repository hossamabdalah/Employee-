package com.empolyee.demo.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

public class Department {
    @Column(name = "name", nullable = false)
    String name;
    @Id
    @UuidGenerator
    private UUID id;


}
