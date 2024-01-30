package com.example.security.service;

import com.example.security.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    List<Book> getAllBooks();

    String addBook(Book book);

    Optional<Book> getBookbyId(int id);

    String deteteBookbyId(int id);

    String updateBookbyId(int id, Book book);
}
