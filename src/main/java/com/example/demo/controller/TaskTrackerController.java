package com.example.demo.controller;


import com.example.demo.payload.TaskRequest;
import com.example.demo.service.TaskTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tracker")
public class TaskTrackerController {
    @Autowired
    TaskTrackerService trackerService;

    @PostMapping("/create")
    public ResponseEntity<?> createTracker() {
        return trackerService.create();
    }
}
