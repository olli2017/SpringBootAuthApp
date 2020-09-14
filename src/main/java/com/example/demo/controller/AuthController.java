package com.example.demo.controller;


import antlr.Token;
import com.example.demo.payload.SigninRequest;
import com.example.demo.payload.SignupRequest;
import com.example.demo.payload.TokenRequest;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AuthController {
    @Autowired
    UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignupRequest signUpRequest) {
        return userService.register(signUpRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SigninRequest signinRequest) {
        return userService.login(signinRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody TokenRequest tokenRequest) {
        return userService.logout(tokenRequest);
    }
}
