package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/util")
public class UtilsController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        List<User> all = userRepo.findAll();

        return ResponseEntity.ok(all);
    }
}
