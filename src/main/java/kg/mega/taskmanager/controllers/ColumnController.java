package kg.mega.taskmanager.controllers;

import kg.mega.taskmanager.models.Column;
import kg.mega.taskmanager.models.dtos.ColumnSwapOrderNumDto;
import kg.mega.taskmanager.models.dtos.ColumnCreationDto;
import kg.mega.taskmanager.services.ColumnService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/column")
public class ColumnController {
    private final ColumnService columnService;

    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @PostMapping("/create")
    public Column createColumn(@RequestBody ColumnCreationDto columnCreationDto) {
        return columnService.createColumn(columnCreationDto);
    }

    @PutMapping("/swap-order")
    public Column swapOrderColumn(@RequestBody ColumnSwapOrderNumDto columnChangeOrderNumDto) {
        return columnService.swapOrderColumn(columnChangeOrderNumDto);
    }
}
