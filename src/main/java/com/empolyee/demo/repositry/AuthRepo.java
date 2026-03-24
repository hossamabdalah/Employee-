package com.empolyee.demo.repositry;

import com.empolyee.demo.entites.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthRepo extends JpaRepository<UserAccount, UUID> {
}
