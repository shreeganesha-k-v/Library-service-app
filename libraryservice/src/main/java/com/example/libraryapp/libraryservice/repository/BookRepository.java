package com.example.libraryapp.libraryservice.repository;

import com.example.libraryapp.libraryservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findBooksByAuthor(String author);
    List<Book> findBooksByName(String name);

}
