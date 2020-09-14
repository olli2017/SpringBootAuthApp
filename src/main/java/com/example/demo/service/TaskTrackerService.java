package com.example.demo.service;

import com.example.demo.model.TaskQueue;
import com.example.demo.repo.TrackerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TaskTrackerService {
    @Autowired
    TrackerRepo trackerRepo;

    public ResponseEntity<?> create() {

        TaskQueue savedTracker = trackerRepo.save(new TaskQueue());

        return ResponseEntity.ok(savedTracker);
    }
}
