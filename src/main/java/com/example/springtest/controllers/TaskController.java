package com.example.springtest.controllers;

import com.example.springtest.entities.Task;
import com.example.springtest.repositories.TaskRepository;
import com.example.springtest.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequiredArgsConstructor
public class TaskController {


    private final TaskService taskService;
    private final TaskRepository taskRepository;


    @RequestMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();

    }

//    @RequestMapping("/tasks/{taskName}")
//    Optional<Task> findByTaskName(@PathVariable String taskName){
//        return taskRepository.findByTaskName(taskName);
//    }
//
//    @RequestMapping("/tasks/{createdAt}")
//    List<Task> findByCreatedAt(@PathVariable Date createdAt){
//        return taskRepository.findByCreatedAt(createdAt);


    @RequestMapping(method = RequestMethod.GET, value = "/tasks/{id}")
    public Task getTask(@PathVariable String id) {
       return taskService.getTask(id);

    }
@RequestMapping(method = RequestMethod.POST, value = "/tasks/task/{id}")
    public void addTask(@RequestBody Task task, @PathVariable String id){
    task.setTaskName(task.getTaskName());
        taskService.addTask(task);
    }


    //public void updateTask(@PathVariable )



}
