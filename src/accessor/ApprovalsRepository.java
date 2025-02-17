package accessor;

import models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApprovalsRepository extends JpaRepository<TaskApproval, Long> {
    List<TaskApproval> findByTask(Task task);
}
