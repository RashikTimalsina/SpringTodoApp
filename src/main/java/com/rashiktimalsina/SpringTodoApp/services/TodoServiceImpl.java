package com.rashiktimalsina.SpringTodoApp.services;

import com.rashiktimalsina.SpringTodoApp.dto.TodoRequestDTO;
import com.rashiktimalsina.SpringTodoApp.dto.TodoResponseDTO;
import com.rashiktimalsina.SpringTodoApp.entities.Todo;
import com.rashiktimalsina.SpringTodoApp.exceptions.ResourceNotFoundException;
import com.rashiktimalsina.SpringTodoApp.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rashik Timalsina
 * @created 13/04/2025
 */

@Service
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with ID: " + id));
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateById(Long id, Todo todo) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with ID: " + id));

        existingTodo.setTitle(todo.getTitle());
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setCompleted(todo.isCompleted());
        existingTodo.setDueDate(todo.getDueDate());


        return todoRepository.save(existingTodo);

    }

    @Override
    public void deleteById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with ID: " + id));
        todoRepository.delete(todo);
    }

    @Override
    public List<Todo> findCompletedById(boolean completed) {
        return todoRepository.findByCompleted(completed);

    }

    private Todo mapToEntity(TodoRequestDTO dto) {
        return new Todo(
                null,
                dto.getTitle(),
                dto.getDescription(),
                dto.isCompleted(),
                dto.getDueDate()
        );

    }

        private TodoResponseDTO mapToResponseDTO(Todo todo) {
            return new TodoResponseDTO(
                    todo.getId(),
                    todo.getTitle(),
                    todo.getDescription(),
                    todo.isCompleted(),
                    todo.getDueDate()
            );
        }

    }


