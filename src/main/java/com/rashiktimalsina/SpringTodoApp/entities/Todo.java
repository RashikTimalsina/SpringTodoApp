package com.rashiktimalsina.SpringTodoApp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Rashik Timalsina
 * @created 13/04/2025
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="todos")
public class Todo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "todo_id", updatable = false, nullable = false)
    private Long id;

    @Column(name="title",nullable = false)
    @NotBlank(message = "Title is required")
    private String title;

    @Column(name="message", nullable = true)
    private String description;

    @Column(name="isCompleted",nullable = false)
    private boolean completed;

    @Column(name="Deadline", nullable = false)
    private LocalDateTime dueDate;


}
