package com.example.security.service.implService;

import com.example.security.entity.Book;
import com.example.security.entity.BorrowingRecord;
import com.example.security.entity.Patron;
import com.example.security.repository.BookRepository;
import com.example.security.repository.BorrowingRecordRepository;
import com.example.security.repository.PatronRepository;
import com.example.security.service.IBorrowingRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BorrowingRecordServiceImpl implements IBorrowingRecordService {

    @Autowired
    BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    BookRepository bookRepo;

    @Autowired
    PatronRepository patronRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowingRecordServiceImpl.class);

    @Override
    public String addBorrowingRecord(int bookId, int patronId, BorrowingRecord borrowingRecord) {

        LOGGER.info(" inside addBorrowingRecord ");
        try {
            Book b = bookRepo.findById(borrowingRecord.getBook().getId()).get();
            borrowingRecord.setBook(b);
            LOGGER.info(" inside addBorrowingRecord : book --> :", b);
        } catch (Exception e) {
            return "No Data Found ";
        }
        try {
            Patron p = patronRepo.findById(borrowingRecord.getPatron().getId()).get();
            borrowingRecord.setPatron(p);
            LOGGER.info(" inside addBorrowingRecord : Patron --> :", p);
            borrowingRecordRepository.save(borrowingRecord);
            return "BorrowingRecord_Added";
        } catch (Exception e) {
            return "No Data Found ";
        }

    }

    @Override
    public String updateBorrowingRecordbyId(int bookId, int patronId, BorrowingRecord borrowingRecord) {

        try {
            Book b = bookRepo.findById(borrowingRecord.getBook().getId()).get();
            borrowingRecord.setBook(b);
            LOGGER.info(" inside addBorrowingRecord : book --> :", b);
        } catch (Exception e) {
            return "No Data Found ";
        }
        try {
            Patron p = patronRepo.findById(borrowingRecord.getPatron().getId()).get();
            borrowingRecord.setPatron(p);
            LOGGER.info(" inside addBorrowingRecord : Patron --> :", p);
            borrowingRecordRepository.save(borrowingRecord);
            return "BorrowingRecord_updated";
        } catch (Exception e) {
            return "No Data Found ";
        }

    }

}
