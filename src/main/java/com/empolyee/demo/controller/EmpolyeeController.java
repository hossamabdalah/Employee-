package com.empolyee.demo.controller;

import com.empolyee.demo.dto.EmpolyeeCreate;
import com.empolyee.demo.dto.EmpolyeeUpdate;
import com.empolyee.demo.dto.LeaveRequestCreate;
import com.empolyee.demo.entites.Empolyee;
import com.empolyee.demo.entites.LeaveRequest;
import com.empolyee.demo.services.EmpolyeeService;
import com.empolyee.demo.services.LeaveRequestService;
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
    private final LeaveRequestService leaveRequestService;


    public EmpolyeeController(EmpolyeeService empolyeeService, LeaveRequestService leaveRequestService) {
        this.empolyeeService = empolyeeService;
        this.leaveRequestService = leaveRequestService;
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
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PostMapping("/{id}/leave-request")
    public ResponseEntity<LeaveRequest> leaveRequest(
            @RequestBody @Valid LeaveRequestCreate leaveRequest, @PathVariable UUID id) {
        LeaveRequest leaverequest = leaveRequestService.create(leaveRequest, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(leaverequest);

    }

    @GetMapping("/{id}/leave-request")
    public ResponseEntity<List<LeaveRequest>> leaveRequestByEmpolyeeId(@PathVariable UUID id) {
        List<LeaveRequest> leaveRequests = leaveRequestService.getByEmpolyeeId(id);
        return new ResponseEntity<>(leaveRequests, HttpStatus.OK);
    }

}
