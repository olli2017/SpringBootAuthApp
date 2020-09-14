package com.example.demo.controller;


import com.example.demo.payload.SignupRequest;
import com.example.demo.payload.TaskRequest;
import com.example.demo.service.SingleTaskService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class SingleTaskController {
    @Autowired
    SingleTaskService taskService;


    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest) {
        return taskService.create(taskRequest);
    }
}
