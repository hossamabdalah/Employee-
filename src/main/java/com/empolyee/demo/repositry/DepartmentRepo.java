package com.empolyee.demo.repositry;

import com.empolyee.demo.entites.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepo extends JpaRepository<Department, UUID> {
}
