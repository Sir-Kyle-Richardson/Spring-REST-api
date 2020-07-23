package com.example.demo.helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Book;

public class JsonLoaderTest {
    @Test
    public void testSaveBooks_savesBooksAsJson() throws IOException {
        Book book = new Book("John", "Some Real Book");
        List<Book> books = new ArrayList<Book>();
        books.add(book);
        boolean isSaved = JsonLoader.saveBooks(books);
        assertTrue(isSaved);
    }

    @Test
    public void testLoadBooks_returnsListOfBooks() throws IOException {
        List<Book> books = JsonLoader.loadBooks();
        Book book = books.get(0);
        assertEquals("John", book.getAuthor());
    }
}