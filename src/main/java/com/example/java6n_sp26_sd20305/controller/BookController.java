package com.example.java6n_sp26_sd20305.controller;


import com.example.java6n_sp26_sd20305.dto.BookRequest;
import com.example.java6n_sp26_sd20305.dto.BookRespone;
import com.example.java6n_sp26_sd20305.entity.Book;
import com.example.java6n_sp26_sd20305.sevicer.BookService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookRespone>> getAllBooks(){

        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<BookRespone> getBookById(@PathVariable Long id) {


        return ResponseEntity.status(HttpStatus.OK).body(bookService.findById(id));
    }


    @PostMapping
//    @RolesAllowed("ADMIN")  // Chỉ cho phép người dùng có vai trò ADMIN mới có thể truy cập endpoint này
//    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")  // Chỉ cho phép người dùng có vai trò ADMIN mới có thể truy cập endpoint này
    public ResponseEntity<BookRespone> addBook(@Valid @RequestBody BookRequest bookRequest){

        return  ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookRequest));

    }

    @PutMapping("/{id}")
    public ResponseEntity<BookRespone> updateBook(@Valid @RequestBody BookRequest bookRequest , @PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(bookService.update(bookRequest, id));



    }


    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteBook(@PathVariable Long id){

        bookService.deleteById(id);
        return ResponseEntity.noContent().build();  //204

    }


}
