package com.ozeyranoglucengizhan.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReturnBookResponse {

    private String bookTitle;

    private String authorFirstName;

    private String authorLastName;

    private String userFirstName;

    private String userLastName;

    private LocalDate borrowDate;

    private LocalDate dueDate;

    private LocalDate returnDate;

    private int overdueDays;

    private double fineAmount;

    private boolean isFinePaid;
}
