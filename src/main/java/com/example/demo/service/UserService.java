package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.payload.SigninRequest;
import com.example.demo.payload.SignupRequest;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public static final String FAKE_TOKEN = "fake";

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

    public ResponseEntity<?> login(SigninRequest signinRequest) {
        String username = signinRequest.getUsername();
        String password = signinRequest.getPassword();

        if (!userRepo.existsByUsername(username)) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: No user with this Username");
        }

        User userFromDB = userRepo.findUserByUsername(username);

        if (!userFromDB.getPassword().equals(password)) {
            return ResponseEntity
                    .badRequest()
                    .body("incorrect password");
        }

        userFromDB.setToken(FAKE_TOKEN);

        return ResponseEntity.ok((userFromDB));

    }
}
