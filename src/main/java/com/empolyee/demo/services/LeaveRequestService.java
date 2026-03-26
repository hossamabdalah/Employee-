package com.empolyee.demo.services;

import com.empolyee.demo.dto.LeaveRequestCreate;
import com.empolyee.demo.entites.Empolyee;
import com.empolyee.demo.entites.LeaveRequest;
import com.empolyee.demo.repositry.EmpolyeeRepo;
import com.empolyee.demo.repositry.LeaveRequestRepo;
import com.empolyee.demo.shared.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LeaveRequestService {
    private final LeaveRequestRepo leaveRequestRepo;
    private final EmpolyeeRepo empolyeeRepo;

    public LeaveRequestService(LeaveRequestRepo leaveRequestRepo, EmpolyeeRepo empolyeeRepo) {
        this.leaveRequestRepo = leaveRequestRepo;
        this.empolyeeRepo = empolyeeRepo;
    }

    public LeaveRequest create(LeaveRequestCreate leaveRequestCreate, UUID employeeId) {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setStatus("PENDING");
        leaveRequest.setReason(leaveRequestCreate.reason());
        leaveRequest.setStartDate(leaveRequestCreate.startDate());
        leaveRequest.setEndDate(leaveRequestCreate.endDate());
        Empolyee empolyee = empolyeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("employee not found"));

        leaveRequest.setEmpolyee(empolyee);

        return leaveRequestRepo.save(leaveRequest);
    }

    public List<LeaveRequest> getByEmpolyeeId(UUID id) {
        return leaveRequestRepo.findByEmpolyee_Id(id);

    }
}
