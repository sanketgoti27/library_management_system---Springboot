package com.example.security.controller;

import com.example.security.entity.BorrowingRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.example.security.entity.Book;
import com.example.security.service.implService.BookServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

//@WebMvcTest(BookController.class)
@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookServiceImpl bookService;

    @InjectMocks
    private BookController bookController;

    @Test
    void getAllBooks() {

        List<Book> expectedBooks = new ArrayList<>();

        when(bookService.getAllBooks()).thenReturn(expectedBooks);

        ResponseEntity<List<Book>> actualResponse = bookController.getAllBooks();

        assertEquals(expectedBooks, actualResponse.getBody());
    }

    @Test
    void testAddBooks() {
        // Arrange
        List<BorrowingRecord> borrowingRecords = new ArrayList<>();
        Book bookToAdd = new Book(1, "TestBook", "TestAuthor", 2022, "123456789",borrowingRecords);
        when(bookService.addBook(bookToAdd)).thenReturn("Book_Added");

        // Act
        ResponseEntity<?> actualResponse = bookController.addBooks(bookToAdd);

        // Assert
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals("Book_Added", actualResponse.getBody());
    }

//    @Test
//    void testGetBookById() {
//        // Arrange
//        List<BorrowingRecord> borrowingRecords = new ArrayList<>();
//        int bookId = 1;
//        Book expectedBook = new Book(bookId, "TestBook", "TestAuthor", 2022, "123456789",borrowingRecords);
//        when(bookService.getBookbyId(bookId)).thenReturn(Optional.of(expectedBook));
//
//        // Act
//        ResponseEntity<?> actualResponse = bookController.getBookById(bookId);
//
//
//        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
//        assertEquals(expectedBook, actualResponse.getBody());
//    }

    @Test
    void testDetetBookById() {
        // Arrange
        int bookId = 1;
        when(bookService.deteteBookbyId(bookId)).thenReturn("Book_Deleted");

        // Act
        ResponseEntity<?> actualResponse = bookController.detetBookById(bookId);

        // Assert
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals("Book_Deleted", actualResponse.getBody());
    }

    @Test
    void testUpdateBookById() {
        // Arrange
        List<BorrowingRecord> borrowingRecords = new ArrayList<>();
        int bookId = 1;
        Book updatedBook = new Book(bookId, "UpdatedBook", "UpdatedAuthor", 2023, "987654321",borrowingRecords);
        when(bookService.updateBookbyId(bookId, updatedBook)).thenReturn("Book_Updated");

        // Act
        ResponseEntity<?> actualResponse = bookController.updateBookById(bookId, updatedBook);

        // Assert
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals("Book_Updated", actualResponse.getBody());
    }

}
