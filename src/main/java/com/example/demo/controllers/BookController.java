package com.example.demo.controllers;

import java.io.IOException;

import com.example.demo.helpers.JsonLoader;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@GetMapping("/books")
	public String getBooks() throws IOException {
        String jsonBooks = JsonLoader.getFileContent();
		return new String(jsonBooks);
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