package models;
import lombok.Data;

import javax.persistence.*;

@Data
public class Approvals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long approvalId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "approver_id")
    private Users approver;

    private Boolean approved = false;
    private String approvalDate;

    // Getters and Setters
}

