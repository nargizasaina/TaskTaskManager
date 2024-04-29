package kg.mega.taskmanager.controllers;

import kg.mega.taskmanager.models.Project;
import kg.mega.taskmanager.models.dtos.ProjectDto;
import kg.mega.taskmanager.services.ColumnService;
import kg.mega.taskmanager.services.ProjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    private final ColumnService columnService;

    public ProjectController(ProjectService projectService, ColumnService columnService) {
        this.projectService = projectService;
        this.columnService = columnService;
    }

    @PostMapping("/create")
    public Project createProject(@RequestBody ProjectDto projectDto) {
        Project project = projectService.createProject(projectDto);
        System.out.println("controller");
//        columnService.createColumnsForProject(project);
        return project;
    }
}
