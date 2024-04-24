package kg.mega.taskmanager.services;

import kg.mega.taskmanager.models.Column;
import kg.mega.taskmanager.models.Project;
import kg.mega.taskmanager.models.dtos.ProjectDto;

import java.util.List;

public interface ColumnService {
    List<Column> createColumns(ProjectDto projectDto, Project project);
}
