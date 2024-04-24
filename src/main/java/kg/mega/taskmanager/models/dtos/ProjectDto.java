package kg.mega.taskmanager.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectDto {
    String name;
    String description;
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date startDate;
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date endDate;
    List<ColumnDto> columns;
}
