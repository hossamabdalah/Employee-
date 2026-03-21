package com.empolyee.demo.controller;

import com.empolyee.demo.dto.DepartmentCreate;
import com.empolyee.demo.entites.Department;
import com.empolyee.demo.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> findAllDepartment() {
        return departmentService.getAll();
    }

    @PostMapping
    public Department create(@RequestBody @Valid DepartmentCreate departmentCreate) {
        return departmentService.create(departmentCreate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable UUID id) {
        Department department = departmentService.getById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable UUID id) {
        departmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
