package com.rashiktimalsina.SpringTodoApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Rashik Timalsina
 * @created 13/04/2025
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Completion status is required")
    private boolean completed;

    private LocalDateTime dueDate;
}
