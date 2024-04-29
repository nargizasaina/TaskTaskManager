package kg.mega.taskmanager.models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;



public class ColumnCreationDto extends ColumnDto{
    Long projectId;


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
