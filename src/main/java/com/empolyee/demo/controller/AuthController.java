package com.empolyee.demo.controller;

import com.empolyee.demo.dto.AuthSignupCreate;
import com.empolyee.demo.services.AuthRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthRequestService authRequestService;

    public AuthController(AuthRequestService authRequestService) {
        this.authRequestService = authRequestService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signin(@RequestBody AuthSignupCreate authSignupCreate) {
        authRequestService.signup(authSignupCreate);
        return new ResponseEntity<>("Signed in", HttpStatus.OK);
    }
}
