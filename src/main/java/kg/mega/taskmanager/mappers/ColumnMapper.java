package kg.mega.taskmanager.mappers;

import kg.mega.taskmanager.models.Column;
//import kg.mega.taskmanager.models.dtos.ColumnDto;
import kg.mega.taskmanager.models.Project;
import kg.mega.taskmanager.models.dtos.ColumnCreationDto;
import kg.mega.taskmanager.models.dtos.ColumnDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ColumnMapper {
    ColumnMapper INSTANCE = Mappers.getMapper(ColumnMapper.class);

    Column ColumnDtoToColumn(ColumnDto columnDto);

    @Mapping(source = "columnCreationDto.projectId", target = "project.id")
    Column columnCreationDtoToColumn(ColumnCreationDto columnCreationDto);
}

