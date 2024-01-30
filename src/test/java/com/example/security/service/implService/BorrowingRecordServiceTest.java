package com.example.security.service.implService;

import com.example.security.entity.Book;
import com.example.security.entity.BorrowingRecord;
import com.example.security.entity.Patron;
import com.example.security.repository.BookRepository;
import com.example.security.repository.BorrowingRecordRepository;
import com.example.security.repository.PatronRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BorrowingRecordServiceTest {

    @Mock
    private BorrowingRecordRepository borrowingRecordRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private BorrowingRecordServiceImpl borrowingRecordService;


    @Test
    void testAddBorrowingRecord_Success() {
        // Arrange
        int bookId = 1;
        int patronId = 2;
        BorrowingRecord borrowingRecord = Mockito.mock(BorrowingRecord.class);
        Book book = Mockito.mock(Book.class);
        Patron patron = Mockito.mock(Patron.class);

        when(borrowingRecord.getBook()).thenReturn(book);
        when(borrowingRecord.getPatron()).thenReturn(patron);
        when(book.getId()).thenReturn(1);
        when(patron.getId()).thenReturn(2);

        when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
        when(patronRepository.findById(patron.getId())).thenReturn(Optional.of(patron));

        // Act
        String result = borrowingRecordService.addBorrowingRecord(bookId, patronId, borrowingRecord);

        // Assert
        assertEquals("BorrowingRecord_Added", result);
        Mockito.verify(borrowingRecordRepository, Mockito.times(1)).save(borrowingRecord);
    }

    @Test
    void testAddBorrowingRecord_PatronNotFound() {
        // Arrange
        int bookId = 1;
        int patronId = 2;
        BorrowingRecord borrowingRecord = Mockito.mock(BorrowingRecord.class);
        Book book = Mockito.mock(Book.class);

        when(borrowingRecord.getBook()).thenReturn(book);
        when(borrowingRecord.getPatron()).thenReturn(Mockito.mock(Patron.class));
        when(book.getId()).thenReturn(1);

        when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
        when(patronRepository.findById(patronId)).thenReturn(Optional.empty());

        // Act
        String result = borrowingRecordService.addBorrowingRecord(bookId, patronId, borrowingRecord);

        // Assert
        assertEquals("No Data Found", result);
        Mockito.verify(borrowingRecordRepository, Mockito.never()).save(borrowingRecord);
    }

    @Test
    void testUpdateBorrowingRecordbyId_Success() {
        // Arrange
        int bookId = 1;
        int patronId = 2;
        BorrowingRecord borrowingRecord = Mockito.mock(BorrowingRecord.class);
        Book book = Mockito.mock(Book.class);
        Patron patron = Mockito.mock(Patron.class);

        when(borrowingRecord.getBook()).thenReturn(book);
        when(borrowingRecord.getPatron()).thenReturn(patron);
        when(book.getId()).thenReturn(1);
        when(patron.getId()).thenReturn(2);

        when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
        when(patronRepository.findById(patron.getId())).thenReturn(Optional.of(patron));

        // Act
        String result = borrowingRecordService.updateBorrowingRecordbyId(bookId, patronId, borrowingRecord);

        // Assert
        assertEquals("BorrowingRecord_updated", result);
        Mockito.verify(borrowingRecordRepository, Mockito.times(1)).save(borrowingRecord);
    }


}
