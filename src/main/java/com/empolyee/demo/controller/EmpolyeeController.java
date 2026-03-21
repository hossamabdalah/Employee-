package com.empolyee.demo.controller;

import com.empolyee.demo.dto.EmpolyeeCreate;
import com.empolyee.demo.dto.EmpolyeeUpdate;
import com.empolyee.demo.entites.Empolyee;
import com.empolyee.demo.services.EmpolyeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("empolyees")
public class EmpolyeeController {
    private final EmpolyeeService empolyeeService;


    public EmpolyeeController(EmpolyeeService empolyeeService) {
        this.empolyeeService = empolyeeService;
    }

    @GetMapping
    public List<Empolyee> getAllEmployees() {
        return empolyeeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empolyee> findone(@PathVariable UUID id) {
        Empolyee empolyee = empolyeeService.getById(id);
        return new ResponseEntity<>(empolyee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Empolyee> create(@RequestBody @Valid EmpolyeeCreate empolyee) {
        Empolyee saved = empolyeeService.create(empolyee);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empolyee> update(
            @Valid
            @PathVariable UUID id,
            @RequestBody EmpolyeeUpdate empolyee
    ) {
        Empolyee updated = empolyeeService.update(id, empolyee);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        empolyeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
