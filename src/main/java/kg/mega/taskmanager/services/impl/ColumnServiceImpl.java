package kg.mega.taskmanager.services.impl;

import kg.mega.taskmanager.models.Column;
import kg.mega.taskmanager.models.Project;
import kg.mega.taskmanager.models.dtos.ColumnDto;
import kg.mega.taskmanager.models.dtos.ProjectDto;
import kg.mega.taskmanager.repos.ColumnRepo;
import kg.mega.taskmanager.services.ColumnService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColumnServiceImpl implements ColumnService {
    private final ColumnRepo columnRepo;

    public ColumnServiceImpl(ColumnRepo columnRepo) {
        this.columnRepo = columnRepo;
    }

    @Override
    public List<Column> createColumns(ProjectDto projectDto, Project project) {
        List<ColumnDto> columnDtos = projectDto.getColumns();
        return columnRepo
                .saveAll(columnDtos
                .stream()
                .map(columnDto -> {
                    Column column = new Column();
                    column.setId(columnDto.getId());
                    column.setName(columnDto.getName());
                    column.setOrderNum(columnDto.getOrderNum());
                    column.setActive(columnDto.isActive());
                    column.setProject(project);
                    return column;
                    }).collect(Collectors.toList())
                );
    }
}
