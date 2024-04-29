package kg.mega.taskmanager.services.impl;

import kg.mega.taskmanager.models.Column;
import kg.mega.taskmanager.models.Project;
import kg.mega.taskmanager.models.Task;
import kg.mega.taskmanager.models.dtos.TaskCreationDto;
import kg.mega.taskmanager.repos.ColumnRepo;
import kg.mega.taskmanager.repos.ProjectRepo;
import kg.mega.taskmanager.repos.TaskRepo;
import kg.mega.taskmanager.services.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;
    private final ProjectRepo projectRepo;
    private final ColumnRepo columnRepo;

    public TaskServiceImpl(TaskRepo taskRepo, ProjectRepo projectRepo, ColumnRepo columnRepo) {
        this.taskRepo = taskRepo;
        this.projectRepo = projectRepo;
        this.columnRepo = columnRepo;
    }

    @Override
    public Task createTask(TaskCreationDto taskCreationDto) {
        Integer lastTaskNum = taskRepo.getLastTaskNumber(taskCreationDto.getProjectId());
        if (lastTaskNum == null) {
            lastTaskNum = 0;
        }

        Task task = new Task();
        task.setTaskNumber(lastTaskNum + 1);
        task.setName(taskCreationDto.getTaskName());
        Column column = columnRepo.findColumnById(taskCreationDto.getColumnId());
        task.setColumn(column);
        System.out.println(column);
        Project project = projectRepo.getProjectById(taskCreationDto.getProjectId());
        task.setProject(project);
        task.setTaskCode(project.getProjectCode() + (lastTaskNum+1));
        taskRepo.save(task);
        return task;
    }
}
