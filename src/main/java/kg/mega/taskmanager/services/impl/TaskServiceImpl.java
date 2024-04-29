package kg.mega.taskmanager.services.impl;

import kg.mega.taskmanager.models.Task;
import kg.mega.taskmanager.models.dtos.TaskCreationDto;
import kg.mega.taskmanager.repos.TaskRepo;
import kg.mega.taskmanager.services.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public Task createTask(TaskCreationDto taskCreationDto) {

        return null;
    }
}
