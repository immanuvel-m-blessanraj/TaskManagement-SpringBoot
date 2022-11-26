package com.example.springtest.services;

import com.example.springtest.entities.Task;
import com.example.springtest.enums.Status;
import com.example.springtest.pojos.TaskDto;
import com.example.springtest.repositories.TaskRepository;
import com.example.springtest.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
//@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {


    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    Task task = new Task();

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }


    //private TaskService taskService;





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
    public List<Task> getAllUserTasks(Long userId) {
        List<Task> tasks = taskRepository.findTaskByUserId(userId);
        return tasks;
    }

    @Override
    public Task getTask(Long id) {
        Task task = taskRepository.findTaskById(id);
        return task;
    }

    @Override
    public Task addTask(TaskDto taskDto) {
        Task task = new Task();
       // BeanUtils.copyProperties(taskDto, task);
        task.setTaskName(taskDto.getTaskName());
        task.setTaskDescription(taskDto.getTaskDescription());
        task.setStatus(Status.PENDING);
        taskRepository.save(task);
        return task;
    }

    @Override
    public Task updateTask(Long id, TaskDto taskDto) {
        if (taskRepository.findById(id).isPresent()) {
            Task existingTask = taskRepository.findById(id).get();
            existingTask.setTaskName(taskDto.getTaskName());
            existingTask.setTaskDescription(taskDto.getTaskDescription());
            taskRepository.save(existingTask);
            return existingTask;
        }
        return null;
    }

    @Override
    public void deleteTask(String taskId) {
        taskRepository.deleteById(taskId);
//        tasks.removeIf(
//                t -> t.getId().equals(id)
//        );
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
