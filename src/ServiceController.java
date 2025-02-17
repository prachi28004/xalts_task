
import models.Approvals;
import models.Task;
import models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.AppService;

@RestController
@RequestMapping("/api/tasks")
public class ServiceController {

    @Autowired
    private AppService taskAppService;

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskAppService.createTask(task);
    }

    @PostMapping("/{taskId}/approve")
    public Approvals approveTask(@PathVariable Long taskId, @RequestBody Users approver) {
        return taskAppService.approveTask(taskId, approver);
    }

    @GetMapping("/{taskId}/status")
    public String getTaskStatus(@PathVariable Long taskId) {
        return taskAppService.getTaskStatus(taskId);
    }
}
