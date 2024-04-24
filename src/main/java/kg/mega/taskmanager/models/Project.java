package kg.mega.taskmanager.models;

import jakarta.persistence.*;
import kg.mega.taskmanager.models.enums.ProjectStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "projects")
public class Project {
    @Id
    Long id;
    String name;
    String description;
    Date startDate;
    Date endDate;
    boolean active;
    @Enumerated(value = EnumType.STRING)
    ProjectStatus status;

}
