package com.todo.resource.service;


import com.todo.entities.Todo;
import com.todo.resource.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodo(final Integer id) {
        return todoRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Todo createTodo(final Todo todo) {
        return todoRepository.save(todo);
    }
}
