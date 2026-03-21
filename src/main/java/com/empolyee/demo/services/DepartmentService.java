package com.empolyee.demo.services;

import com.empolyee.demo.entites.Department;
import com.empolyee.demo.repositry.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

}
