package com.ozeyranoglucengizhan.library_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "return_books")
public class ReturnBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "borrowed_book_id", nullable = false)
    private BorrowedBooks borrowedBooks;

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    @Column(name = "overdue_days")
    private Integer overdueDays;

    @Column(name = "fine_amount")
    private Double fineAmount;
}
