package services;


import accessor.ApprovalsRepository;
import accessor.TaskRepository;
import accessor.UserRepository;
import models.Approvals;
import models.Task;
import models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppMainService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ApprovalsRepositoryRepository taskApprovalRepository;

    @Autowired
    private UserRepository userRepository;

    public Task createTask(Task task) {
        // Save the task to the database
        return taskRepository.save(task);
    }

    public Approvals approveTask(Long taskId, Users approver) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        Approvals approval = new Approvals();
        approval.setTask(task);
        approval.setApprover(approver);
        approval.setApproved(true);

        // Save the approval to the database
        return taskApprovalRepository.save(approval);
    }

    public String getTaskStatus(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        List<Approvals> approvals = taskApprovalRepository.findByTask(task);

        // Count how many approvals are true
        long approvedCount = approvals.stream().filter(TaskApproval::getApproved).count();

        if (approvedCount == 3) {
            task.setStatus("Approved");
        } else {
            task.setStatus("Pending");
        }

        taskRepository.save(task);
        return task.getStatus();
    }
}

