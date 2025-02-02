package com.example.libraryapp.libraryservice.service;

import com.example.libraryapp.libraryservice.model.Book;
import com.example.libraryapp.libraryservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public List<Book> getByAuthor(String author){
        return bookRepository.findBooksByAuthor(author);
    }

    public List<Book> getByName(String name){
        return bookRepository.findBooksByName(name);
    }

    public Book addBook(Book  book){
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setAuthor(bookDetails.getAuthor());
            book.setName(bookDetails.getName());
            book.setPrice(bookDetails.getPrice());
            book.setCount(bookDetails.getCount());
            return bookRepository.save(book); // Save the updated book
        } else {
            throw new ResourceAccessException("Book not found with id: " + id);
        }
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
