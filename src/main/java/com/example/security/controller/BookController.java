package com.example.security.controller;

import com.example.security.entity.Book;
import com.example.security.service.implService.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        LOGGER.info( " inside getAllBooks");
        List<Book> books = bookServiceImpl.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> addBooks(@Valid @RequestBody Book book) {
        LOGGER.info( " inside addBooks");
        String result = bookServiceImpl.addBook(book);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin') ||  hasAuthority('User')")
    public ResponseEntity<?> getBookById(@PathVariable("id") int id) {
        LOGGER.info( " inside getBookById");
        Optional<Book> result = bookServiceImpl.getBookbyId(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> detetBookById(@PathVariable("id") int id) {
        LOGGER.info( " inside detetBookById ");
        String result = bookServiceImpl.deteteBookbyId(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin') ||  hasAuthority('User')")
    public ResponseEntity<?> updateBookById(@Valid @PathVariable int id, @RequestBody Book book) {
        LOGGER.info( " inside updateBookById ");
        // Path variable is not required for update data but still, it you want to use then you can use from here.
        String result = bookServiceImpl.updateBookbyId(id , book);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
