package com.rashiktimalsina.SpringTodoApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rashiktimalsina.SpringTodoApp.entities.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rashik Timalsina
 * @created 13/04/2025
 */

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    List<Todo> findByCompleted(boolean completed);

}
