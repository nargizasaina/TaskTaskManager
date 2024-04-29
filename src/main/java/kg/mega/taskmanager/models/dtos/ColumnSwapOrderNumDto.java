package kg.mega.taskmanager.models.dtos;

public class ColumnSwapOrderNumDto {
    private Long projectId;
    private Long firstColumnId;
    private Long secondColumnId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getFirstColumnId() {
        return firstColumnId;
    }

    public void setFirstColumnId(Long firstColumnId) {
        this.firstColumnId = firstColumnId;
    }

    public Long getSecondColumnId() {
        return secondColumnId;
    }

    public void setSecondColumnId(Long secondColumnId) {
        this.secondColumnId = secondColumnId;
    }
}
