
package com.bank_login.bankProject;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

// This represents the table in a database
// Create a Task entity with fields: id, title, description, dueDate, status.

@Entity// Marks this as an Entity
@Table(name = "tasks")// Explicit table name
public class Task {
    @Id
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)// For primary keys
    private String id;
    private String title;
    private String description;
    @Column(name = "due_date")// Maps to "due_date" column in the table
    private LocalDate dueDate;
    @Enumerated(EnumType.STRING)// Store enum value as string (e.g.., "PENDING")
    private TaskStatus status;// eg..,'PENDING' 'COMPLETED'

    // We use enum to restrict the values strictly to PENDING or COMPLETED
    public enum TaskStatus {
        PENDING, COMPLETED
    }
    // Set my constructor

    public Task() {
    }
    public Task(String title, String description, LocalDate dueDate, TaskStatus status) {
        // I did not use id because the database auto-generates an id//
        // id is important for creating new tasks

        this.title=title;
        this.description=description;
        this.dueDate=dueDate;
        this.status=status;
    }
    // Set my Getters and Setters to access the private data

    public String getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = String.valueOf(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = TaskStatus.valueOf(status);
    }
}
