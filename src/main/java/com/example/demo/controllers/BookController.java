package com.example.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@GetMapping("/books")
	public String getBooks() {
		return String.format("Hello!");
    }
    
    @PostMapping("/books")
    public String createBook() {
        return String.format("Successfully created book");
    }

    @DeleteMapping("/books/:id")
    public String deleteBook() {
     
        return String.format("Successfully deleted book");
    }

    @PutMapping("/books/:id")
    public String updateBook() {
        return String.format("Successfully updated book");
    }
}