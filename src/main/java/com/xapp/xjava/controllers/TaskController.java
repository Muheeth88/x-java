package com.xapp.xjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xapp.xjava.entities.Task;
import com.xapp.xjava.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("")
    ResponseEntity<Task> createTask(@RequestBody Task req) {
        Task savedTask = taskService.createTask(req);
        return ResponseEntity.ok(savedTask);
    }
}
