package kg.mega.taskmanager.services;

import kg.mega.taskmanager.models.Column;
import kg.mega.taskmanager.models.Project;
import kg.mega.taskmanager.models.dtos.ColumnSwapOrderNumDto;
import kg.mega.taskmanager.models.dtos.ColumnCreationDto;
import kg.mega.taskmanager.models.dtos.ColumnDto;

import java.util.List;

public interface ColumnService {
//    List<Column> createColumns(ProjectDto projectDto, Project project);

    Column createColumn(ColumnCreationDto columnCreationDto);

    void createColumnsForNewProject(List<ColumnDto> columnDtos, Project project);

    Column swapOrderColumn(ColumnSwapOrderNumDto columnChangeOrderNumDto);
}
