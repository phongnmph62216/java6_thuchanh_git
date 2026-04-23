package com.example.java6n_sp26_sd20305.sevicer.impl;


import com.example.java6n_sp26_sd20305.entity.Todo;
import com.example.java6n_sp26_sd20305.exception.CustomResourceotFoundException;
import com.example.java6n_sp26_sd20305.repository.TodoRepository;
import com.example.java6n_sp26_sd20305.sevicer.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class TodoServiceImpl  implements TodoService {

    private  final TodoRepository todoRepository;


    @Override
    public List<Todo> FindAll() {
        return todoRepository
                .findAll();
    }

    @Override
    public Todo FindById(Long id) {
        return todoRepository
                .findById(id)
                .orElseThrow(() -> new CustomResourceotFoundException("Todo with id " + id + " not found"));
    }

    @Override
    public Todo Add(Todo todo) {
        return todoRepository
                .save(todo);
    }

    @Override
    public Todo Update(Long id, Todo todo) {
        return todoRepository
                .findById(id)
                .map(existing -> {
                    if (todo.getTitle() != null) existing.setTitle(todo.getTitle());
                    if (todo.getDescription() != null) existing.setDescription(todo.getDescription());
                    existing.setCompleted(todo.getCompleted());

                    return todoRepository.save(existing);
                })
                .orElse(null);
    }

    @Override
    public Todo Delete(Long id) {
       Todo deletedTodo = FindById(id);

        if (deletedTodo != null) {
            todoRepository.deleteById(id);
        }

        return deletedTodo;
    }



}
