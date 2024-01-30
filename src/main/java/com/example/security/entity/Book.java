package com.example.security.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "title(Book-Name) is mandatory")
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;

    @OneToMany(mappedBy = "book")
    private List<BorrowingRecord> borrowingRecords = new ArrayList<>();

}
