package com.example.springtest.controllers;

import com.example.springtest.entities.Task;
import com.example.springtest.pojos.TaskDto;
import com.example.springtest.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@Component
//@RequiredArgsConstructor
@RequestMapping("/user")
public class TaskController {


    private final TaskService taskService;
   // private final UserService userService;



    public TaskController(TaskService taskService) {
        this.taskService = taskService;
        //this.userService = userService;
    }
   // private final TaskRepository taskRepository;
    TaskDto taskDto;
//    @PostMapping("/signup")
//public ResponseEntity<String> userSignUp(@RequestBody UserDto userDto) {
//        userService.userSignUp(userDto);
//        return new ResponseEntity<>("Sign up successful!", HttpStatus.CREATED);
//}
//    @GetMapping ("/profile/{userId}")
//    public ResponseEntity<List<TaskDto>> getAllUserTasks(@PathVariable Long userId) {
//        List<TaskDto> taskDtoList = taskService.getAllUserTasks(userId);
//        return new ResponseEntity<>(taskDtoList, HttpStatus.OK);
//
//    }

//    @RequestMapping("/tasks/{taskName}")
//    Optional<Task> findByTaskName(@PathVariable String taskName){
//        return taskRepository.findByTaskName(taskName);
//    }
//
//    @RequestMapping("/tasks/{createdAt}")
//    List<Task> findByCreatedAt(@PathVariable Date createdAt){
//        return taskRepository.findByCreatedAt(createdAt);


    @GetMapping("/task/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
      Task task = taskService.getTask(taskId);
       // TaskDto task = null;
        return new ResponseEntity<>(task, HttpStatus.OK);

    }
    @PostMapping("/addtask")
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDto){
        taskService.addTask(taskDto);
        //String outcome = "Task is added successfully!";
    return new ResponseEntity<>(taskDto, HttpStatus.CREATED);
    }

    @PutMapping("/update/{taskId}")
    public ResponseEntity<String> updateTask(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        taskService.updateTask(taskId, taskDto);
        return new ResponseEntity<>("Task updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>("Task deleted successfully!", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/status/prog/{taskId}")
    public ResponseEntity<String> pendingToProgress(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        taskService.pendingToInProgress(taskId, taskDto);
        return new ResponseEntity<>("Task status changed successfully!", HttpStatus.OK);
    }

    // public Task InProgressBackToPending(Long id, TaskDto taskDto)
    @PutMapping("/status/pend/{taskId}")
    public ResponseEntity<String> InProgressToPending(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        taskService.InProgressBackToPending(taskId, taskDto);
        return new ResponseEntity<>("Task status changed successfully", HttpStatus.OK);
    }
    @PutMapping("/status/done/{taskId}")
    public ResponseEntity<String> InProgressToDone(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        taskService.InProgressToDone(taskId, taskDto);
        return new ResponseEntity<>("Task status changed successfully", HttpStatus.OK);
    }

}
