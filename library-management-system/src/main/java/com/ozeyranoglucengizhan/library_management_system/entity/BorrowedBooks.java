package com.ozeyranoglucengizhan.library_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


}
