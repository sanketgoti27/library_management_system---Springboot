package com.example.security.controller;

import com.example.security.entity.Patron;
import com.example.security.service.IPatronService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    @Autowired
    IPatronService iPatronService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PatronController.class);

    @GetMapping
    public ResponseEntity<List<Patron>> getAllPatrons() {
        LOGGER.info(" inside getAllPatrons");
        List<Patron> patrons = iPatronService.getAllPatrons();
        return new ResponseEntity<>(patrons, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> addPatrons(@Valid @RequestBody Patron patron) {
        LOGGER.info(" inside addPatrons");
        String result = iPatronService.addPatron(patron);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin') ||  hasAuthority('User')")
    public ResponseEntity<?> getPatronById(@PathVariable("id") int id) {
        LOGGER.info(" inside getPatronById");
        String result = iPatronService.getPatronbyId(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> detetPatronById(@PathVariable("id") int id) {
        LOGGER.info(" inside detetPatronById");
        String result = iPatronService.detetePatronbyId(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin') ||  hasAuthority('User')")
    public ResponseEntity<?> updatePatronById(@Valid @PathVariable int id, @RequestBody Patron patron) {
        LOGGER.info(" inside updatePatronById");
        // Path variable is not required for update data but still, it you want to use then you can use from here.
        String result = iPatronService.updatePatronbyId(id, patron);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
