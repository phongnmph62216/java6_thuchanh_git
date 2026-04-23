package com.example.java6n_sp26_sd20305.sevicer.impl;

import com.example.java6n_sp26_sd20305.dto.BookRequest;
import com.example.java6n_sp26_sd20305.dto.BookRespone;
import com.example.java6n_sp26_sd20305.entity.Book;
import com.example.java6n_sp26_sd20305.exception.CustomResourceotFoundException;
import com.example.java6n_sp26_sd20305.repository.BookRepository;
import com.example.java6n_sp26_sd20305.sevicer.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service

public class BookServiceImpl implements BookService {

     private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<BookRespone> findAll() {
        return  bookRepository
                .findAll()
                .stream()
                .map(   book -> modelMapper.map(book, BookRespone.class))
                .toList();
    }

    @Override
    public BookRespone findById(Long id) {
        return bookRepository.findById(id)
                .map(book -> modelMapper.map(book, BookRespone.class))
                .orElseThrow(() -> new CustomResourceotFoundException("Book not found with id: " + id));
    }


    @Override
    public BookRespone save(BookRequest bookRequest) {
        Book book = modelMapper.map(bookRequest, Book.class);

        book.setIsbn(generateIsbn());

        book = bookRepository.save(book);

        return modelMapper.map(book, BookRespone.class);

    }

    private String generateIsbn() {
        return  "ISBN-" + UUID.randomUUID().toString().substring(0,13);

    }

    @Override
    public BookRespone update(BookRequest bookRequest, Long id) {
        return bookRepository.findById(id)
                .map(  b -> {
                    if (bookRequest.getTitle() != null) b.setTitle(bookRequest.getTitle());
                    if (bookRequest.getAuthor() != null) b.setAuthor(bookRequest.getAuthor());
                    if(bookRequest.getPrice() >= 0) b.setPrice(bookRequest.getPrice());

                    bookRepository.save(b);
                    return modelMapper.map(b, BookRespone.class);
                })
                .orElseThrow(() -> new CustomResourceotFoundException("Book not found with id: " + id));
    }

    @Override
    public void  deleteById(Long id) {
        bookRepository.deleteById(id);

    }






}
