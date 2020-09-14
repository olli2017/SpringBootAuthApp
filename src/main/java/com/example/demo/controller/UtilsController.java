package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.repo.TaskRepo;
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

    @Autowired
    TaskRepo taskRepo;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> all = userRepo.findAll();

        return ResponseEntity.ok(all);
    }

    @GetMapping("/tasks")
    public ResponseEntity<?> getAllTasks() {
        List<Task> all = taskRepo.findAll();

        return ResponseEntity.ok(all);
    }
}
