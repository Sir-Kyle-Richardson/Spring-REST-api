package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

import com.example.demo.helpers.JsonLoader;
import com.example.demo.models.Book;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@GetMapping("/books")
	public String getBooks() throws IOException {
        String jsonBooks = JsonLoader.getFileContent();
		return new String(jsonBooks);
    }
    
    @PostMapping("/books")
    public String createBook(@RequestBody Book newBook) throws IOException {
        List<Book> books = JsonLoader.loadBooks();
        books.add(newBook);
        JsonLoader.saveBooks(books);
        return String.format("Successfully created book");
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable UUID id) throws IOException {
        List<Book> books = JsonLoader.loadBooks();
        ListIterator<Book> booksIterator = books.listIterator();
        while (booksIterator.hasNext()) {
            Book book = booksIterator.next();
            if (book.getId().equals(id)) {
                booksIterator.remove();
                JsonLoader.saveBooks(books);
                return String.format("Successfully deleted book");
            }
        }

        return String.format("Failed to delete book");
    }

    @PutMapping("/books/{id}")
    public String updateBook(@PathVariable UUID id, @RequestBody Book updatedBook) throws IOException {
        List<Book> books = JsonLoader.loadBooks();
        ListIterator<Book> booksIterator = books.listIterator();
        while (booksIterator.hasNext()) {
            Book book = booksIterator.next();
            if (book.getId().equals(id)) {
                booksIterator.set(updatedBook);
                JsonLoader.saveBooks(books);
                return String.format("Successfully updated book");
            }
        }

        return String.format("Failed to updated book");
    }
}