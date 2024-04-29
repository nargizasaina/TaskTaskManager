package kg.mega.taskmanager.repos;

import kg.mega.taskmanager.models.Column;
import kg.mega.taskmanager.models.Project;
import kg.mega.taskmanager.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    @Query(value = "select max(t.taskNumber) from Task t where t.project.id = ?1")
    Integer getLastTaskNumber(Long id);

}
