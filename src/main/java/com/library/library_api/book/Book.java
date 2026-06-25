package com.library.library_api.book;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "books")
@Data


public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    @Column(nullable = false)
    String title;
    @NotBlank
    @Column(nullable = false)
    String author;
    @Size(max = 13)
    String isbn;
    @NotNull
    Integer publishedYear;
}
