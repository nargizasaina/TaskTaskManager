package kg.mega.taskmanager.controllers;

import kg.mega.taskmanager.models.Task;
import kg.mega.taskmanager.models.dtos.TaskCreationDto;
import kg.mega.taskmanager.services.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody TaskCreationDto taskCreationDto) {
        return taskService.createTask(taskCreationDto);
    }
}
