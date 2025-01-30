package com.bank_login.bankProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")// This the base url for all endpoints.., i.e GET, POST, PUT, DELETE

public class TaskController {
    @Autowired
    private TaskService taskService;

    //POST http://localhost:8080/api/tasks
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }
    //Get all tasks
    //GET http://localhost:8080/api/tasks
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    //Get a single task
    // GET http://localhost:8080/api/tasks/1
    @GetMapping("/{id}")
    public Task getOneTask(@PathVariable Long id) {
        return taskService.getSingleTask(id);
    }

    //Delete Tasks
    //DELETE http:localhost:8080/api/tasks/1
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
