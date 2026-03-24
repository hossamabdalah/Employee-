package com.empolyee.demo.services;

import com.empolyee.demo.dto.AuthSignupCreate;
import com.empolyee.demo.entites.Empolyee;
import com.empolyee.demo.entites.UserAccount;
import com.empolyee.demo.repositry.AuthRepo;
import com.empolyee.demo.repositry.EmpolyeeRepo;
import com.empolyee.demo.shared.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthRequestService {
    private final AuthRepo authRepo;
    private final PasswordEncoder passwordEncoder;
    private final EmpolyeeRepo empolyeeRepo;

    public AuthRequestService(AuthRepo authRepo, EmpolyeeRepo empolyeeRepo, PasswordEncoder passwordEncoder) {
        this.authRepo = authRepo;
        this.empolyeeRepo = empolyeeRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(AuthSignupCreate authSignupCreate) {
        Empolyee existing = empolyeeRepo.findById(authSignupCreate.employeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        UserAccount userAccount = new UserAccount();
        userAccount.setFirstName(authSignupCreate.firstName());
        userAccount.setPassword(passwordEncoder.encode(authSignupCreate.password()));
        userAccount.setEmpolyee(existing);

        authRepo.save(userAccount);

    }
}
