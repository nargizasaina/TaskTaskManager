package kg.mega.taskmanager.services.impl;

import kg.mega.taskmanager.mappers.ProjectMapper;
import kg.mega.taskmanager.models.Column;
import kg.mega.taskmanager.models.Project;
import kg.mega.taskmanager.models.dtos.ProjectDto;
import kg.mega.taskmanager.repos.ProjectRepo;
import kg.mega.taskmanager.services.ColumnService;
import kg.mega.taskmanager.services.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ColumnService columnService;
    private final ProjectRepo projectRepo;

    public ProjectServiceImpl(ColumnService columnService, ProjectRepo projectRepo) {
        this.columnService = columnService;
        this.projectRepo = projectRepo;
    }

    @Override
    public Project createProject(ProjectDto projectDto) {
        Project project = ProjectMapper.INSTANCE.ProjectDtoToProject(projectDto);
        project = projectRepo.save(project);

        List<Column> columns = columnService.createColumns(projectDto, project);

        return project;
    }
}
