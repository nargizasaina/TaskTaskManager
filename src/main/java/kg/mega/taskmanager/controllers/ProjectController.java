package kg.mega.taskmanager.controllers;

import kg.mega.taskmanager.models.Project;
import kg.mega.taskmanager.models.dtos.ProjectDto;
import kg.mega.taskmanager.services.ProjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/create")
    public Project createProject(@RequestBody ProjectDto projectDto) {
        return projectService.createProject(projectDto);
    }
}
