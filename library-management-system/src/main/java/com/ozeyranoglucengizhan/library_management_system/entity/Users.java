package com.ozeyranoglucengizhan.library_management_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseEntity {

    @Column(name = "users_first_name",nullable = false)
    private String userFirstName;

    @Column(name= "users_last_name",nullable = false)
    private String userLastName;

    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<BorrowedBooks> borrowedBooks;


}
