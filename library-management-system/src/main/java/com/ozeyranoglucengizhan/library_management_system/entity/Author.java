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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author extends BaseEntity {

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "author")
    private List<Books> book;

}
