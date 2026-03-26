package com.empolyee.demo.repositry;

import com.empolyee.demo.entites.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthRepo extends JpaRepository<UserAccount, UUID> {
    Optional<UserAccount> findOneByUserName(String username);

    boolean existsByEmpolyee_Id(UUID employeeId);
}
