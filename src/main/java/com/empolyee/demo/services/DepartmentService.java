package com.empolyee.demo.services;

import com.empolyee.demo.dto.DepartmentCreate;
import com.empolyee.demo.entites.Department;
import com.empolyee.demo.repositry.DepartmentRepo;
import com.empolyee.demo.shared.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService {
    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

    public Department create(DepartmentCreate departmentCreate) {
        Department department = new Department();

        department.setName(departmentCreate.name());

        return departmentRepo.save(department);

    }

    public Department getById(UUID id) {
        return departmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empolyee with" + id + "not found"));
    }

    public void delete(UUID id) {
        departmentRepo.deleteById(id);
    }

}
