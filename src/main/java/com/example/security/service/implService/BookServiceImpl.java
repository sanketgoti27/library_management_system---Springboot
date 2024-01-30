package com.example.security.service.implService;

import com.example.security.entity.Book;
import com.example.security.repository.BookRepository;
import com.example.security.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BookRepository bookRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public List<Book> getAllBooks() {
        LOGGER.info("inside getAllBooks");
        return bookRepository.findAll();
    }

    @Override
    public String addBook(Book book) {
        LOGGER.info("inside addBook");
        bookRepository.save(book);
        return "Book_Added";
    }

    @Override
    public Optional<Book> getBookbyId(int id) {
        LOGGER.info("inside getBookbyId");
        Optional<Book> book = bookRepository.findById(id);
        return book;
    }

    @Override
    public String deteteBookbyId(int id) {
        LOGGER.info("inside deteteBookbyId");
        bookRepository.deleteById(id);
        return "Book_Deteted";
    }

    @Override
    public String updateBookbyId(int id, Book book) {
        LOGGER.info("inside updateBookbyId");
        book.setId(id);
        bookRepository.save(book);
        return "Book_updated";
    }
}
