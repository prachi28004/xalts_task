package accessor;

import models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Task, Long> {
}
