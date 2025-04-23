package com.rashiktimalsina.SpringTodoApp.services;

import com.rashiktimalsina.SpringTodoApp.entities.Todo;

import java.util.List;

/**
 * @author Rashik Timalsina
 * @created 13/04/2025
 */
public interface TodoService {

    List<Todo>findAll();

    Todo findById(Long id);

    Todo createTodo(Todo todo);

    Todo updateById(Long id, Todo todo);

    void deleteById(Long id);

    List<Todo> findCompletedById(boolean completed);

}
