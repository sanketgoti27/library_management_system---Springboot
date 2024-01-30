package com.example.security.controller;

import com.example.security.entity.BorrowingRecord;
import com.example.security.service.implService.BorrowingRecordServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/borrowingRecords")
public class BorrowingRecordController {

    @Autowired
    BorrowingRecordServiceImpl borrowingRecordServiceImpl;

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowingRecordController.class);

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> addBorrowingRecords(@Valid @PathVariable int bookId,
                                                  @PathVariable int patronId,
                                                  @RequestBody BorrowingRecord borrowingRecord) {
        LOGGER.info( " inside addBorrowingRecords");
        String result = borrowingRecordServiceImpl.addBorrowingRecord(bookId, patronId ,borrowingRecord);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> updateBorrowingRecordById(@Valid @PathVariable int bookId,
                                                         @PathVariable int patronId, @RequestBody BorrowingRecord borrowingRecord) {
        LOGGER.info( " inside updateBorrowingRecordById");
        // Path variable is not required for update data but still, it you want to use then you can use from here.
        String result = borrowingRecordServiceImpl.updateBorrowingRecordbyId(bookId,patronId, borrowingRecord);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
