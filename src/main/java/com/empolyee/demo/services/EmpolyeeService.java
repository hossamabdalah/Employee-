package com.empolyee.demo.services;

import com.empolyee.demo.dto.EmpolyeeCreate;
import com.empolyee.demo.dto.EmpolyeeUpdate;
import com.empolyee.demo.entites.Department;
import com.empolyee.demo.entites.Empolyee;
import com.empolyee.demo.repositry.DepartmentRepo;
import com.empolyee.demo.repositry.EmpolyeeRepo;
import com.empolyee.demo.shared.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmpolyeeService {
    private final EmpolyeeRepo empolyeeRepo;
    private final DepartmentRepo departmentRepo;


    public EmpolyeeService(EmpolyeeRepo empolyeeRepo, DepartmentRepo departmentRepo) {
        this.empolyeeRepo = empolyeeRepo;
        this.departmentRepo = departmentRepo;


    }

    public List<Empolyee> getAll() {
        return empolyeeRepo.findAll();
    }

    public Empolyee getById(UUID id) {
        return empolyeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empolyee with ID:" + id + " is not exist"));
    }

    public Empolyee create(EmpolyeeCreate empolyee) {
        Empolyee employee = new Empolyee();

        employee.setFirstName(empolyee.firstName());
        employee.setLastName(empolyee.lastName());
        employee.setEmail(empolyee.email());
        employee.setPhoneNumber(empolyee.phoneNumber());
        employee.setHireDate(empolyee.hireDate());
        employee.setPosition(empolyee.position());
        Department department = departmentRepo.findById(empolyee.departmentId()).orElseThrow(() -> new RuntimeException("Department not found!"));
        employee.setDepartmentId(department);
        return empolyeeRepo.save(employee);
    }

    public Empolyee update(UUID id, EmpolyeeUpdate empolyee) {
        Empolyee existing = empolyeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        existing.setFirstName(empolyee.firstName());
        existing.setLastName(empolyee.lastName());
        existing.setPhoneNumber(empolyee.phoneNumber());
        existing.setHireDate(empolyee.hireDate());
        existing.setPosition(empolyee.position());

        return empolyeeRepo.save(existing);
    }

    public void delete(UUID id) {
        Empolyee existing = empolyeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        empolyeeRepo.delete(existing);
    }
}
