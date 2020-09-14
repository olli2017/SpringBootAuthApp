package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.payload.SigninRequest;
import com.example.demo.payload.SignupRequest;
import com.example.demo.payload.TokenRequest;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
            return badRequestWithMessage("Error: Username is already taken!");
        }

        if (userRepo.existsByEmail(email)) {
            return badRequestWithMessage("Error: Email is already in use!");
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
            return badRequestWithMessage("Error: No user with this Username");
        }

        User userFromDB = userRepo.findUserByUsername(username);

        if (!userFromDB.getPassword().equals(password)) {
            return badRequestWithMessage("Incorrect password");
        }

        userFromDB.setToken(FAKE_TOKEN);
        User updatedUser = updateUser(userFromDB);

        return ResponseEntity.ok((updatedUser));
    }


    public ResponseEntity<?> logout(TokenRequest tokenRequest) {
        User userFromDB = userRepo.findUserByToken(tokenRequest.getToken());
        if (userFromDB == null) {
            return badRequestWithMessage("User with this token not found");
        }

        userFromDB.setToken(null);
        User updatedUser = updateUser(userFromDB);

        return ResponseEntity.ok((updatedUser));
    }

    private ResponseEntity<String> badRequestWithMessage(String s) {
        return ResponseEntity
                .badRequest()
                .body(s);
    }

    private User updateUser(User userFromDB) {
        userRepo.delete(userFromDB);
        return userRepo.save(userFromDB);
    }
}
