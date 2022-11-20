package com.example.springtest.services;

import com.example.springtest.entities.Task;
import com.example.springtest.exceptions.TaskNotFoundException;
import com.example.springtest.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    //private TaskService taskService;



    @Override
    public List<Task> getAllTasks() {
        List<Task> taskList = new ArrayList<>();
        taskRepository.findAll()
                .forEach(taskList::add);
        return taskList;
    }

//    @Override
//    public void getTask(String task) {
//
//    }

//    public Sample getOneSample(String taskName) {
//        return sampleRepository.findOne(taskName);
//    }

    //Finds sample by task name
//    Optional<Task> findByTaskName(String taskName) {
//        return taskRepository.findByTaskName(taskName);
//    }
//
//    //Finds sample by date created
//    List<Task> findByCreatedAt(Date createdAt) {
//        return taskRepository.findByCreatedAt(createdAt);
//    }
//
//    //Finds by id
//    Task findById(String id){
////        List<Sample> sampleList = new ArrayList<>();
////        List<Sample> sampleIds = new ArrayList<>();
//     return    tasks.stream()
//                .filter(t -> t.getId().equals(id))
//                .findFirst()
//                .get();
////    for (int i = 0; i < sampleList.size(); i++) {
////        if (sampleIds)
////    }
//
//    }




    @Override
    public Task getTask(String id) {
      return   tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .get();

    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void updateTask(String id, Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            Task s = tasks.get(i);
            if (s.getId().equals(id)) {
                tasks.set(i, task);
                return;
            }
        }
    }

    @Override
    public void deleteTask(String id) {
        tasks.removeIf(
                t -> t.getId().equals(id)
        );
    }


//    public Sample item(String taskName) {
//        Sample sample = sampleRepository.findByTitle(taskName);
//        if(taskName == null) {
//            throw new TaskNotFoundException("Task does not exist!");
//        } else {
//            return sample;
//        }
//    }

//    public Task user(String id) {
//        Task task = taskRepository.findById(id);
//        if (id == null) {
//            throw new TaskNotFoundException("Task does not exist!");
//        } else {
//            return task;
//        }
//    }
}
