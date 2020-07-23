package com.example.demo.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Type;

import com.example.demo.models.Book;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.springframework.util.ResourceUtils;

public class JsonLoader {
    private static String getFileContent(String filename) throws IOException {
        File file = ResourceUtils.getFile("classpath:books.json");
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        return new String(fileBytes);
    }


    public static List<Book> loadBooks() throws IOException {
        Gson gson = new Gson();
        String jsonString = getFileContent("books.json");
        Type type = new TypeToken<List<Book>>() {}.getType();
        List<Book> books = gson.fromJson(jsonString, type);

        if (books == null) {
            return new ArrayList<Book>();
        }

        return books;
    }
}