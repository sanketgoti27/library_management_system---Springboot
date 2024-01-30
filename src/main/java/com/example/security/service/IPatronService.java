package com.example.security.service;

import com.example.security.entity.Patron;

import java.util.List;

public interface IPatronService {

    List<Patron> getAllPatrons();

    String addPatron(Patron patron);

    String getPatronbyId(int id);

    String detetePatronbyId(int id);

    String updatePatronbyId(int id , Patron patron);
}
