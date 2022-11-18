package com.example.springtest.services;

import com.example.springtest.entities.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface TaskService {
    List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks();

    public void createSample(String task);

    public void addSample(Task task);

    public void updateSample(String id, Task task);

    public void deleteSample(String id);

}
