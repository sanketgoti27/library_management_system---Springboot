package com.example.security.service.implService;

import com.example.security.entity.Book;
import com.example.security.entity.BorrowingRecord;
import com.example.security.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    public void testGetAllBooks() {
        List<Book> books = new ArrayList<>();
        List<BorrowingRecord> borrowingRecords = new ArrayList<>();
        books.add(new Book(1, "Book1", "Author1", 2022, "123456789" , borrowingRecords));
        books.add(new Book(2, "Book2", "Author2", 2021, "987654321" , borrowingRecords));

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.getAllBooks();

        assertEquals(2, result.size());
    }

    @Test
    public void testAddBook() {
        List<BorrowingRecord> borrowingRecords = new ArrayList<>();
        Book bookToAdd = new Book(3, "NewBook", "NewAuthor", 2023, "111222333" ,borrowingRecords);

        when(bookRepository.save(bookToAdd)).thenReturn(bookToAdd);

        String result = bookService.addBook(bookToAdd);

        assertEquals("Book_Added", result);
        Mockito.verify(bookRepository, Mockito.times(1)).save(bookToAdd);
    }

    @Test
    public void testGetBookById() {
        int bookId = 1;
        List<BorrowingRecord> borrowingRecords = new ArrayList<>();
        Book book = new Book(bookId, "Book1", "Author1", 2022, "123456789",borrowingRecords);

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        Optional<Book> result = bookService.getBookbyId(bookId);

        assertEquals(book, result.orElse(null));
    }

    @Test
    public void testDeleteBookById() {
        int bookId = 1;
//        List<BorrowingRecord> borrowingRecords = new ArrayList<>();
        String result = bookService.deteteBookbyId(bookId);

        assertEquals("Book_Deteted", result);
        Mockito.verify(bookRepository, Mockito.times(1)).deleteById(bookId);
    }

    @Test
    public void testUpdateBookById() {
        int bookId = 1;
        List<BorrowingRecord> borrowingRecords = new ArrayList<>();
        Book updatedBook = new Book(bookId, "UpdatedBook", "UpdatedAuthor", 2022, "123456789",borrowingRecords);

        when(bookRepository.save(updatedBook)).thenReturn(updatedBook);

        String result = bookService.updateBookbyId(bookId, updatedBook);

        assertEquals("Book_updated", result);
        Mockito.verify(bookRepository, Mockito.times(1)).save(updatedBook);
    }
}
