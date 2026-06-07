package com.library.library_api.book;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data


public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    String author;
    String isbn;
    Integer publishedYear;
}
