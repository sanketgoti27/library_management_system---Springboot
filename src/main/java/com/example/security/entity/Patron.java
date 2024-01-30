package com.example.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Patron")
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "name must Required")
    private String name;

    @Column(nullable = false)
    private int roleId;

    @NotBlank(message = "Password must Required")
    private String password;
    private String contactInformation;

    @OneToMany(mappedBy = "patron")
    private List<BorrowingRecord> borrowingRecords = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "roleId", referencedColumnName = "roleId", insertable = false, updatable = false)
    private Role role;
}