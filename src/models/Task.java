package models;

import lombok.Data;

import javax.persistence.*;

@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String title;
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Users createdBy;
}