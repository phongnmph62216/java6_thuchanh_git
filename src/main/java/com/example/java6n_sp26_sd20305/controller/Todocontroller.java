package com.example.java6n_sp26_sd20305.controller;

import com.example.java6n_sp26_sd20305.entity.Todo;
import com.example.java6n_sp26_sd20305.sevicer.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class Todocontroller {
    private final TodoService todoService;

    // api/todos
    @GetMapping
    public ResponseEntity< List<Todo> > getAllTodos() {
        List<Todo> todos = todoService.FindAll();
//        return  new ResponseEntity<>(todos, HttpStatus.OK);

//        return  ResponseEntity.ok(todos);


//       return  ResponseEntity
//               .status(HttpStatus.OK)
//               .body(todos);

    return  ResponseEntity
            .ok()
            .header("Customs-Header", "Customs-values")
            .body(todos);


    }



    // api/todos/{id}
    @GetMapping("/{id}")
    public   ResponseEntity<Todo> getTodoById ( @PathVariable  Long id) {
        Todo todos =  todoService.FindById(id);
        return new  ResponseEntity<>(todos,HttpStatus.OK);
    }



    //add
    //api/todos
    @PostMapping
    public  ResponseEntity<Todo> AddTodo( @Valid  @RequestBody Todo todo ){
        Todo saveTodos =  todoService.Add(todo);
        return  new ResponseEntity<>(saveTodos,HttpStatus.CREATED);  //201

    }


    //update
    // api/todos/{id}
    @PutMapping("/{id}")
    public  ResponseEntity<Todo> UpdateTodo( @PathVariable Long id,@Valid @RequestBody Todo todo){
        Todo todosupadte =  todoService.Update(id,todo);
        return  new ResponseEntity<>(todosupadte,HttpStatus.OK);
    }



    //delete
    //api/todos/{id}
    @DeleteMapping("/{id}")
    public  ResponseEntity<Todo> DeleteTodo(@PathVariable Long id){
        Todo deleteTodos =  todoService.Delete(id);

        return  new ResponseEntity<>(deleteTodos,HttpStatus.OK);

    }





}
