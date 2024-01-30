package com.example.security.service.implService;

import com.example.security.entity.Patron;
import com.example.security.repository.PatronRepository;
import com.example.security.service.IPatronService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronServiceImpl implements IPatronService {

    @Autowired
    PatronRepository patronRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(PatronServiceImpl.class);

    @Override
    public List<Patron> getAllPatrons() {
        LOGGER.info( " inside getAllPatrons");
        return patronRepository.findAll();
    }

    @Override
    public String addPatron(Patron patron) {
        LOGGER.info( " inside addPatron");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(patron.getPassword());
        patron.setPassword(password);
        patronRepository.save(patron);
        return "Patron_Added";
    }

    @Override
    public String getPatronbyId(int id) {
        LOGGER.info( " inside getPatronbyId");
        patronRepository.findById(id);
        return "Patron_Added";
    }

    @Override
    public String detetePatronbyId(int id) {
        patronRepository.deleteById(id);
        return "Patron_Deteted";
    }

    @Override
    public String updatePatronbyId(int id, Patron patron) {
        LOGGER.info( " inside updatePatronbyId");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(patron.getPassword());
        patron.setPassword(password);
        patronRepository.save(patron);
        return "Patron_updated";
    }
}
