package com.rashiktimalsina.SpringTodoApp.controller;

import com.rashiktimalsina.SpringTodoApp.entities.Todo;
import com.rashiktimalsina.SpringTodoApp.services.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rashik Timalsina
 * @created 13/04/2025
 */

@RestController
@RequestMapping("/api/todo/")
public class TodoController {

    private final TodoService todoService;


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.findById(id));
    }


    @GetMapping("/completed/{completed}")
    public List<Todo> getTodosByCompletion(@PathVariable boolean completed) {
        return todoService.findCompletedById(completed);
    }


    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }


    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.updateById(id, todo);
    }


    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteById(id);
        return "Task removed successfully";
    }


}
