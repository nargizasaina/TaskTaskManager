package kg.mega.taskmanager.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "columns")
public class Column {
    @Id
    Long id;
    String name;
    int orderNum;
    boolean active;
    @ManyToOne
    @JoinColumn(name = "project_id")
    Project project;
}
