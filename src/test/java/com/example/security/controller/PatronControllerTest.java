//package com.example.security.Controller;
//
//import com.example.security.Controller.PatronController;
//import com.example.security.Entity.BorrowingRecord;
//import com.example.security.Entity.Patron;
//import com.example.security.Service.PatronServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//public class PatronControllerTest {
//
//    @Mock
//    private PatronServiceImpl patronService;
//
//    @InjectMocks
//    private PatronController patronController;
//
//    @Test
//    void testGetAllPatrons() {
//        // Arrange
//        List<Patron> expectedPatrons = new ArrayList<>();
//        when(patronService.getAllPatrons()).thenReturn(expectedPatrons);
//
//        // Act
//        ResponseEntity<List<Patron>> actualResponse = patronController.getAllPatrons();
//
//        // Assert
//        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
//        assertEquals(expectedPatrons, actualResponse.getBody());
//    }
//
//    @Test
//    void testAddPatrons() {
//        // Arrange
//        List<BorrowingRecord> borrowingRecords = new ArrayList<>();
//        Patron patronToAdd = new Patron(1, "John Doe", "john@example.com","password", borrowingRecords);
//        when(patronService.addPatron(patronToAdd)).thenReturn("Patron_Added");
//
//        // Act
//        ResponseEntity<?> actualResponse = patronController.addPatrons(patronToAdd);
//
//        // Assert
//        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
//        assertEquals("Patron_Added", actualResponse.getBody());
//    }
//
//    @Test
//    void testGetPatronById() {
//        // Arrange
//        int patronId = 1;
//        when(patronService.getPatronbyId(patronId)).thenReturn("Patron_Found");
//
//        // Act
//        ResponseEntity<?> actualResponse = patronController.getPatronById(patronId);
//
//        // Assert
//        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
//        assertEquals("Patron_Found", actualResponse.getBody());
//    }
//
//    @Test
//    void testDetetPatronById() {
//        // Arrange
//        int patronId = 1;
//        when(patronService.detetePatronbyId(patronId)).thenReturn("Patron_Deleted");
//
//        // Act
//        ResponseEntity<?> actualResponse = patronController.detetPatronById(patronId);
//
//        // Assert
//        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
//        assertEquals("Patron_Deleted", actualResponse.getBody());
//    }
//
//    @Test
//    void testUpdatePatronById() {
//        // Arrange
//        List<BorrowingRecord> borrowingRecords = new ArrayList<>();
//        int patronId = 1;
//        Patron updatedPatron = new Patron(patronId, "UpdatedName", "updated@example.com","password", borrowingRecords);
//        when(patronService.updatePatronbyId(patronId, updatedPatron)).thenReturn("Patron_Updated");
//
//        // Act
//        ResponseEntity<?> actualResponse = patronController.updatePatronById(patronId, updatedPatron);
//
//        // Assert
//        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
//        assertEquals("Patron_Updated", actualResponse.getBody());
//    }
//}
