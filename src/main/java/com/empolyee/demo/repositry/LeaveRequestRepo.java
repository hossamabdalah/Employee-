package com.empolyee.demo.repositry;

import com.empolyee.demo.entites.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, UUID> {
    List<LeaveRequest> findByEmpolyee_Id(UUID id);
}
