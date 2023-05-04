package com.xapp.xjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xapp.xjava.entities.Task;
import com.xapp.xjava.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task req) {
        Task newTask = new Task();
        newTask.setTitle(req.getTitle());
        newTask.setDescription(req.getDescription());
        return taskRepository.save(newTask);
    }
}
