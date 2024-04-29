package kg.mega.taskmanager.repos;

import kg.mega.taskmanager.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
    @Query("select p from Project p where p.id = :id")
    Project getProjectById(Long id);

    Project findProjectByProjectCode(String code);
}
