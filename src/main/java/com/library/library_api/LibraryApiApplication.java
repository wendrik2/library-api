package com.library.library_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApiApplication.class, args);
	}

}
/*
* Анотації на методах:

@GetMapping — обробляє GET запит
@PostMapping — обробляє POST запит
@PathVariable — бере значення з URL, наприклад /api/books/1
@RequestBody — бере JSON з тіла запиту
* */