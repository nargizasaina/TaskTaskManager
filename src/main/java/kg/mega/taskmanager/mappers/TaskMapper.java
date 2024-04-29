package kg.mega.taskmanager.mappers;

import kg.mega.taskmanager.models.Task;
import kg.mega.taskmanager.models.dtos.TaskCreationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);
    Task taskCreationDtoToTask(TaskCreationDto taskCreationDto);
}
