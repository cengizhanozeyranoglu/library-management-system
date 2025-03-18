package com.ozeyranoglucengizhan.library_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "borrowed_books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowedBooks extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Books book;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "borrowed_date", nullable = false)
    private LocalDate borrowedDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @OneToOne(mappedBy = "borrowedBooks",cascade = CascadeType.REMOVE)
    private ReturnBooks returnBooks;

}
