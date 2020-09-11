package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.payload.SignupRequest;
import com.example.demo.repo.UserRepo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;


    public ResponseEntity<?> register(SignupRequest signUpRequest) {
        String username = signUpRequest.getUsername();
        String email = signUpRequest.getEmail();
        String password = signUpRequest.getPassword();

        if (userRepo.existsByUsername(username)) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (userRepo.existsByEmail(email)) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        User user = new User(username, email, password);

        User saved = userRepo.save(user);
        System.out.println("user saved: " + saved);

        return ResponseEntity.ok(("User registered successfully!"));
    }
}
