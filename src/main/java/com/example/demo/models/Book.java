package com.example.demo.models;

import java.util.UUID;

public class Book {
    private final UUID id;
    private final String author;
    private final String title;

    public Book(String author, String title) {
        this.id = UUID.randomUUID();
        this.author = author;
        this.title = title;
    }

    public UUID getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }
}