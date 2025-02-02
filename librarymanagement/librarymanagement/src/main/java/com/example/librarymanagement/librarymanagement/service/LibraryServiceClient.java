package com.example.librarymanagement.librarymanagement.service;


import com.example.librarymanagement.librarymanagement.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@FeignClient(name = "book-service", url = "http://host.docker.internal:8081") // Replace with actual base URL
public interface LibraryServiceClient {

    @GetMapping("/books")
    List<Book> getBooks(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "author", required = false) String author
    );

    @PostMapping("/books")
    Book addBook(@RequestBody Book book);

    @PutMapping("/books/{id}")
    Book updateBook(@PathVariable("id") Long id, @RequestBody Book book);

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable("id") Long id);
}
