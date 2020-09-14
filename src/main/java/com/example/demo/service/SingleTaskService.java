package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.payload.TaskRequest;
import com.example.demo.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SingleTaskService {
    @Autowired
    TaskRepo taskRepo;

    public ResponseEntity<?> create(TaskRequest taskRequest) {
        Task savedTask = taskRepo.save(new Task(taskRequest.getName(), taskRequest.getDescription()));

        return ResponseEntity.ok(savedTask);

    }
}
