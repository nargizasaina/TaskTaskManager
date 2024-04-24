package kg.mega.taskmanager.services;

import kg.mega.taskmanager.models.Project;
import kg.mega.taskmanager.models.dtos.ProjectDto;

public interface ProjectService {
    Project createProject(ProjectDto projectDto);
}
