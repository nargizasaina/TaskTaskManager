package kg.mega.taskmanager.services;

import kg.mega.taskmanager.models.Task;
import kg.mega.taskmanager.models.dtos.TaskCreationDto;

public interface TaskService {
    Task createTask(TaskCreationDto taskCreationDto);
}
