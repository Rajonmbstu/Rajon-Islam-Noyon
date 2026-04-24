package com.taskmanager.smart_task_manager;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime deadline;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Enums
    public enum Priority {
        HIGH, MEDIUM, LOW
    }

    public enum Status {
        PENDING, COMPLETED
    }

    // Constructors
    public Task() {}

    public Task(String title, String description, Priority priority,
                Status status, LocalDateTime deadline, User user) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.deadline = deadline;
        this.createdAt = LocalDateTime.now();
        this.user = user;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public LocalDateTime getDeadline() { return deadline; }
    public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
