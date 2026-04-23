package com.example.java6n_sp26_sd20305.sevicer;

import com.example.java6n_sp26_sd20305.dto.BookRequest;
import com.example.java6n_sp26_sd20305.dto.BookRespone;
import com.example.java6n_sp26_sd20305.entity.Book;

import java.util.List;

public interface BookService {




    List<BookRespone> findAll();

    BookRespone findById(Long id);


    BookRespone save(BookRequest bookRequest);

    BookRespone update(BookRequest bookRequest, Long id);

void deleteById(Long id);




}
