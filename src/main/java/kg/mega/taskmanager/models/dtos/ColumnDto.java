package kg.mega.taskmanager.models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ColumnDto {
    Long id;
    String name;
    int orderNum;
    boolean active;
}
