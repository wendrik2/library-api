package com.library.library_api.controller;

import com.library.library_api.book.Book;
import com.library.library_api.repository.BookRepository;
import com.library.library_api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }
    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id){
        return bookService.getById(id);
    }

    @PutMapping("{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }
}

