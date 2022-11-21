package com.example.springtest.controllers;

import com.example.springtest.entities.Task;
import com.example.springtest.repositories.TaskRepository;
import com.example.springtest.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Component
//@RequiredArgsConstructor
@RequestMapping("/api")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
   // private final TaskRepository taskRepository;


    @GetMapping ("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> taskList = taskService.getAllTasks();
        return new ResponseEntity<>(taskList, HttpStatus.OK);

    }

//    @RequestMapping("/tasks/{taskName}")
//    Optional<Task> findByTaskName(@PathVariable String taskName){
//        return taskRepository.findByTaskName(taskName);
//    }
//
//    @RequestMapping("/tasks/{createdAt}")
//    List<Task> findByCreatedAt(@PathVariable Date createdAt){
//        return taskRepository.findByCreatedAt(createdAt);


    @GetMapping("/task/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable String taskId) {
       Task task = taskService.getTask(taskId);
       return new ResponseEntity<>(task, HttpStatus.OK);

    }
    @PostMapping("/addtask")
    public ResponseEntity<String> addTask(@RequestBody Task task){
        taskService.addTask(task);
    return new ResponseEntity<>("Task added successfully!", HttpStatus.CREATED);
    }

    @PutMapping("/task/{taskId}/updatetask")
    public ResponseEntity<String> updateTask(@PathVariable String taskId, @RequestBody Task task) {
        taskService.updateTask(taskId, task);
        return new ResponseEntity<>("Task updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable String taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>("Task deleted successfully!", HttpStatus.NO_CONTENT);
    }

}
