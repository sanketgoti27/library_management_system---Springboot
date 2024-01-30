package com.example.security.service.implService;


import com.example.security.entity.BorrowingRecord;
import com.example.security.entity.Patron;
import com.example.security.entity.Role;
import com.example.security.repository.PatronRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PatronServiceTest {

    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private PatronServiceImpl patronService;


    @Test
    void testGetAllPatrons() {
        // Arrange
        List<Patron> patrons = new ArrayList<>();
        patrons.add(new Patron(1, "John Doe", 1, "password123", "john@example.com", new ArrayList<>(), new Role()));

        when(patronRepository.findAll()).thenReturn(patrons);

        // Act
        List<Patron> result = patronService.getAllPatrons();

        // Assert
        assertEquals(1, result.size());
        assertEquals(patrons, result);
        verify(patronRepository, times(1)).findAll();
    }


    @Test
    void testAddPatron() {
        Patron patron = new Patron(1, "John Doe", 1, "password123", "john@example.com", new ArrayList<>(), new Role());

        BCryptPasswordEncoder passwordEncoder = Mockito.mock(BCryptPasswordEncoder.class);
        when(passwordEncoder.encode(patron.getPassword())).thenReturn("encodedPassword");

        String result = patronService.addPatron(patron);

        assertEquals("Patron_Added", result);
        verify(patronRepository, times(1)).save(patron);
    }


    @Test
    void testGetPatronById() {

        int id = 1;

        String result = patronService.getPatronbyId(id);

        assertEquals("Patron_Added", result);
        verify(patronRepository, times(1)).findById(id);
    }

    @Test
    void testDeletePatronById() {
        // Arrange
        int id = 1;

        // Act
        String result = patronService.detetePatronbyId(id);

        // Assert
        assertEquals("Patron_Deteted", result);
        verify(patronRepository, times(1)).deleteById(id);
    }
    @Test
    void testUpdatePatronById() {
        int id = 1;
        Patron patron = new Patron(1, "John Doe", 1, "password123", "john@example.com", new ArrayList<>(), new Role());

        BCryptPasswordEncoder passwordEncoder = Mockito.mock(BCryptPasswordEncoder.class);
        when(passwordEncoder.encode(patron.getPassword())).thenReturn("encodedPassword");


        String result = patronService.updatePatronbyId(id, patron);

        // Assert
        assertEquals("Patron_updated", result);
        verify(patronRepository, times(1)).save(patron);
    }
}