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

//    @Override
//        public List<Column> createColumns(ProjectDto projectDto, Project project) {
////        List<ColumnDto> columnDtos = projectDto.getColumns();
//        AtomicInteger order = new AtomicInteger(1);
//        return columnRepo
//                .saveAll(projectDto.getColumns()
//                .stream()
//                .map(columnDto -> {
//                    Column column = new Column();
//                    column.setId(columnDto.getId());
//                    column.setName(columnDto.getName());
//                    column.setOrderNum(order.getAndIncrement());
//                    column.setActive(columnDto.isActive());
//                    column.setProject(project);
//                    return column;
//                    }).collect(Collectors.toList())
//                );
//    }

    @Override
    public void createColumnsForNewProject(List<ColumnDto> columnDtos, Project project) {
//        List<Column> columns = new ArrayList<>();
//        int order = 1;
//        System.out.println(project.getId());
//        for (ColumnDto columnDto : columnDtos) {
//            System.out.println(columnDto.getName());
//            Column column = new Column();
//            column.setProject(project);
//            column.setName(columnDto.getName());
//            column.setActive(true);
//            column.setOrderNum(order);
//            columns.add(column);
//            order++;
//            System.out.println(2);
//            columnRepo.save(column);
//            System.out.println(column.getId());
//            System.out.println(column.getProject());
//            System.out.println(column.getName());
//        }
////        List<Column> columns = ColumnMapper.INSTANCE.ColumnDtosToColumns(columnDtos, project);
////        columnRepo.saveAll(columns);
//        System.out.println("map");

        AtomicInteger order = new AtomicInteger(1);

        // You can log column details here if needed, similar to your original code
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
        System.out.println(1);
        List<Long> orders = List.of(columnChangeOrderNumDto.getFirstColumnId(), columnChangeOrderNumDto.getSecondColumnId());
        Project project = new Project();
        System.out.println(2);
        project.setId(columnChangeOrderNumDto.getProjectId());
        System.out.println(3);
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
