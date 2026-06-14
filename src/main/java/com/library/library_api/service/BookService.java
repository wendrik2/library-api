package com.library.library_api.service;

import com.library.library_api.book.Book;
import com.library.library_api.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.VoiceStatus;
import java.util.List;

@Service
@RequiredArgsConstructor

public class BookService {

    private final BookRepository bookRepository;


    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getById(Long id){
        return bookRepository.findById(id).orElseThrow();
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book){
        return bookRepository.findById(id).map(existing->{
            existing.setTitle(book.getTitle());
            existing.setAuthor(book.getAuthor());
            existing.setIsbn(book.getIsbn());
            existing.setPublishedYear(book.getPublishedYear());
            return bookRepository.save(existing);
        }).orElseThrow();
    }

    public ResponseEntity<Void> deleteBook(Long id){
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
