package kg.mega.taskmanager.mappers;

import kg.mega.taskmanager.models.Project;
import kg.mega.taskmanager.models.dtos.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    Project ProjectDtoToProject(ProjectDto projectDto);
}
