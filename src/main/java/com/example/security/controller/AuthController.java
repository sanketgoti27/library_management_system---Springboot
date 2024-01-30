package com.example.security.controller;

import com.example.security.entity.JwtRequest;
import com.example.security.service.implService.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/auth/login")
//    @PreAuthorize("hasAuthority('Admin') ||  hasAuthority('User')")
    public Object authenticateAndGetToken(@Valid @RequestBody JwtRequest jwtRequest) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

            if (authenticate.isAuthenticated()) {
                return jwtService.generateToken(jwtRequest.getUsername());
            } else {
                return ResponseEntity.status(403).body("Invalid credentials");
            }
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(403).body("Invalid Please Check Username and Password ");
        }
    }
}