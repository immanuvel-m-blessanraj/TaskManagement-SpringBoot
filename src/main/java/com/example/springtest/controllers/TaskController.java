package com.example.springtest.controllers;

import com.example.springtest.entities.Task;
import com.example.springtest.repositories.TaskRepository;
import com.example.springtest.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Component
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    private final TaskService taskService;
    private final TaskRepository taskRepository;


    @RequestMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();

    }

    @RequestMapping("/tasks/{taskName}")
    Optional<Task> findByTaskName(@PathVariable String taskName){
        return taskRepository.findByTaskName(taskName);
    }



}
