package kg.mega.taskmanager.repos;

import kg.mega.taskmanager.models.Column;
import kg.mega.taskmanager.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColumnRepo extends JpaRepository<Column, Long> {
    @Query(value = "select max(c.orderNum) from Column c where c.project.id = ?1")
    Integer getLastOrderNum(Long id);

    List<Column> findAllByProjectAndIdIn(Project project, List<Long> columnIds);

    Column findColumnById(Long columnId);
}
