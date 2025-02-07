package com.example.librarymanagement.librarymanagement.controller;

import com.example.librarymanagement.librarymanagement.model.Book;
import com.example.librarymanagement.librarymanagement.service.LibraryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryManagementController {
    @Autowired
    LibraryServiceClient serviceClient;

    @PostMapping("/books")
    @CacheEvict(value = "books",allEntries = true)
    public Book saveBook(@RequestBody Book book){
        return serviceClient.addBook(book);
    }

    @GetMapping("/books")
    @Cacheable(value = "books",key = "#name + ':' +#author")
    public List<Book> getAllBooks(
            @RequestParam(value = "name",required = false)String name,
            @RequestParam(value = "author",required = false)String author){
        return serviceClient.getBooks(name,author);
    }

    @PutMapping("/books/{id}")
    @CacheEvict(value = "books",allEntries = true)
    public Book updateBooks(@PathVariable("id")Long id, @RequestBody Book book){
        return serviceClient.updateBook(id,book);
    }

    @DeleteMapping("/books/{id}")
    @CacheEvict(value = "books",allEntries = true)
    public void deleteBooks(@PathVariable("id")Long id){
        serviceClient.deleteBook(id);
    }
}
