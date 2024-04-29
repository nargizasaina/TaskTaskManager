package kg.mega.taskmanager.services.impl;

import kg.mega.taskmanager.mappers.ColumnMapper;
import kg.mega.taskmanager.models.Column;
import kg.mega.taskmanager.models.Project;
import kg.mega.taskmanager.models.dtos.ColumnSwapOrderNumDto;
import kg.mega.taskmanager.models.dtos.ColumnCreationDto;
import kg.mega.taskmanager.models.dtos.ColumnDto;
import kg.mega.taskmanager.repos.ColumnRepo;
import kg.mega.taskmanager.services.ColumnService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ColumnServiceImpl implements ColumnService {
    private final ColumnRepo columnRepo;

    public ColumnServiceImpl(ColumnRepo columnRepo) {
        this.columnRepo = columnRepo;
    }

    @Override
    public void createColumnsForNewProject(List<ColumnDto> columnDtos, Project project) {
        AtomicInteger order = new AtomicInteger(1);
        List<Column> columns = columnDtos.stream()
                .map(columnDto -> {
                    Column column = new Column();
                    column.setProject(project);
                    column.setName(columnDto.getName());
                    column.setActive(true);
                    column.setOrderNum(order.getAndIncrement());
                    return column;
                })
                .collect(Collectors.toList());

        columnRepo.saveAll(columns);
    }

    @Override
    public Column swapOrderColumn(ColumnSwapOrderNumDto columnChangeOrderNumDto) {
        List<Long> orders = List.of(columnChangeOrderNumDto.getFirstColumnId(), columnChangeOrderNumDto.getSecondColumnId());
        Project project = new Project();
        project.setId(columnChangeOrderNumDto.getProjectId());
        List<Column> columns = columnRepo.findAllByProjectAndIdIn(project, orders);
        int tempOrderNum = columns.get(0).getOrderNum() ;
        columns.get(0).setOrderNum(columns.get(1).getOrderNum());
        columns.get(1).setOrderNum(tempOrderNum);
        columnRepo.saveAll(columns);
        return null;
    }

    @Override
    public Column createColumn(ColumnCreationDto columnCreationDto) {
        Column column = ColumnMapper.INSTANCE.columnCreationDtoToColumn(columnCreationDto);
        int lastOrderNum = columnRepo.getLastOrderNum(column.getProject().getId());
        column.setOrderNum(lastOrderNum + 1);
        column.setActive(true);
        column = columnRepo.save(column);
        return column;
    }
}
