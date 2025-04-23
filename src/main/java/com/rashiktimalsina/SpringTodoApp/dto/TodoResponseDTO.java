package com.rashiktimalsina.SpringTodoApp.dto;

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
public class TodoResponseDTO {

    private Long id;

    private String title;

    private String description;

    private boolean completed;

    private LocalDateTime dueDate;


}
