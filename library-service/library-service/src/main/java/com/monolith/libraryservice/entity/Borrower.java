package com.edureka.libraryManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "borrower")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Date activeSince;
    private Date dateOfBirth;
    private String address;
    private Date borrowedBookOn;
    private float lateFeeAmount;
    private String membershipStatus;
    private Long contactNumber;
    @OneToMany
    private List<Book> books;

}
