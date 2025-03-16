package com.ozeyranoglucengizhan.library_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrowed_books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowedBooks extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "borrowed_date", nullable = false)
    private LocalDate borrowedDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "overdue_days", nullable = false)
    private int overdueDays = 0;

    @Column(name = "fine_amount", nullable = false)
    private double fineAmount = 0.0;

    @Column(name = "is_fine_paid", nullable = false)
    private boolean isFinePaid = false;


}
