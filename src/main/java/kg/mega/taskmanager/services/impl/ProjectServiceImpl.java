package kg.mega.taskmanager.services.impl;

import kg.mega.taskmanager.mappers.ProjectMapper;
import kg.mega.taskmanager.models.Column;
import kg.mega.taskmanager.models.Project;
import kg.mega.taskmanager.models.dtos.ColumnDto;
import kg.mega.taskmanager.models.dtos.ProjectDto;
import kg.mega.taskmanager.repos.ProjectRepo;
import kg.mega.taskmanager.services.ColumnService;
import kg.mega.taskmanager.services.ProjectService;
import org.springframework.stereotype.Service;

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
        String projectCode = generateCode(project.getName(), 2);
        project.setProjectCode(projectCode);
        project = projectRepo.save(project);
        columnService.createColumnsForNewProject(projectDto.getColumns(), project);

        return project;
    }

    private String generateCode(String name, int length) {
        String code = name.substring(0, length).toUpperCase();
        System.out.println(code);
        Project project = projectRepo.findProjectByProjectCode(code);
        if (project != null){
            return generateCode(name, length + 1);
        }
        return code;
    }
}
