package com.example.java6n_sp26_sd20305.sevicer;

import com.example.java6n_sp26_sd20305.entity.Todo;

import java.util.List;

public interface TodoService {


    List<Todo>  FindAll();

    Todo FindById(Long id);

    Todo Add(Todo todo);

    Todo Update(Long id, Todo todo);

    Todo Delete(Long id);


}
