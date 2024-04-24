package kg.mega.taskmanager.mappers;

import kg.mega.taskmanager.models.Column;
//import kg.mega.taskmanager.models.dtos.ColumnDto;
import kg.mega.taskmanager.models.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ColumnMapper {
    ColumnMapper INSTANCE = Mappers.getMapper(ColumnMapper.class);

//    Column ColumnDtoToColumn(ColumnDto columnDto);
//    List<Column> ColumnDtosToColumns(List<ColumnDto> columnDtoList, Project project);
}

