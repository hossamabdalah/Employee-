package com.empolyee.demo.services;

import com.empolyee.demo.dto.AuthSignupCreate;
import com.empolyee.demo.entites.Empolyee;
import com.empolyee.demo.entites.UserAccount;
import com.empolyee.demo.repositry.AuthRepo;
import com.empolyee.demo.repositry.EmpolyeeRepo;
import com.empolyee.demo.shared.BadCredentialsException;
import com.empolyee.demo.shared.ConflictException;
import com.empolyee.demo.shared.ResourceNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthRequestService implements UserDetailsService {
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

        if (authRepo.existsByEmpolyee_Id(authSignupCreate.employeeId())) {

            throw new ConflictException("Thisssssss employee already has an account");

        }
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(authSignupCreate.userName());
        userAccount.setPassword(passwordEncoder.encode(authSignupCreate.password()));
        userAccount.setEmpolyee(existing);

        authRepo.save(userAccount);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount> userAccount = authRepo.findOneByUserName(username);
        if (userAccount.isEmpty()) {
            throw new BadCredentialsException("User not found");
        }
        UserAccount user = userAccount.get();
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
