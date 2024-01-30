package com.example.security.repository;

import com.example.security.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron, Integer> {

    Patron findByName(String username);
}
