package com.empolyee.demo.repositry;

import com.empolyee.demo.entites.Empolyee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmpolyeeRepo extends JpaRepository<Empolyee, UUID> {
}
