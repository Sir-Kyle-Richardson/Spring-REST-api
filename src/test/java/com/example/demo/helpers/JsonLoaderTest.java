package com.example.demo.helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import com.example.demo.models.Book;

public class JsonLoaderTest {
    @Test
    public void testLoadBooks_returnsListOfBooks() throws IOException {
        List<Book> books = JsonLoader.loadBooks();
        Book book = books.get(0);
        assertEquals("John", book.getAuthor());
    }
}