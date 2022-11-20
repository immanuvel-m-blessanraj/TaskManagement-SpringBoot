package com.example.springtest.services;

import com.example.springtest.entities.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface TaskService {
    List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks();

    public Task getTask(String id);

    public void addTask(Task task);

    public void updateTask(String id, Task task);

    public void deleteTask(String id);

}
