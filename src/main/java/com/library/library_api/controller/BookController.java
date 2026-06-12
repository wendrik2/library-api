package com.library.library_api.controller;

import com.library.library_api.book.Book;
import com.library.library_api.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id){
        return bookRepository.findById(id).orElseThrow();
    }
    @PutMapping("{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book){
        return bookRepository.findById(id).map(existing -> {
            existing.setTitle(book.getTitle());
            existing.setAuthor(book.getAuthor());
            existing.setIsbn(book.getIsbn());
            existing.setPublishedYear(book.getPublishedYear());
            return bookRepository.save(existing);
        }).orElseThrow();
    }
}

