package kg.mega.taskmanager.repos;

import kg.mega.taskmanager.models.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnRepo extends JpaRepository<Column, Long> {
}
