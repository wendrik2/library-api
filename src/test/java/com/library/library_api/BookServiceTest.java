package com.library.library_api;

import com.library.library_api.book.Book;
import com.library.library_api.exception.BookNotFoundException;
import com.library.library_api.repository.BookRepository;
import com.library.library_api.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class BookServiceTest {
    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @Test
    void getAllBooks_shouldReturnListOfBooks(){

        Book book = new Book();
        book.setTitle("Clear Code");
        Pageable pageable = PageRequest.of(0, 10);
        Page<Book> page = new PageImpl<>(List.of(book));
        when(bookRepository.findAll(pageable)).thenReturn(page);


        Page<Book> result = bookService.getAllBooks(pageable);


        assertEquals(1, result.getContent().size());
        assertEquals("Clear Code", result.getContent().get(0).getTitle());


    }
    @Test
    void getById_shouldThrowException_whenBookNotFound() {
        // Arrange
        when(bookRepository.findById(999L)).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(BookNotFoundException.class, () -> bookService.getById(999L));
    }
}
