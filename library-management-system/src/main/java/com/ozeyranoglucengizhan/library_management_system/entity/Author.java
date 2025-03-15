package com.ozeyranoglucengizhan.library_management_system.entity;

import jakarta.persistence.*;
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

    @Column(name = "author_name",nullable = false)
    private String authorName;

    @Column(name = "author_last_name",nullable = false)
    private String authorLastName;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY)
    private List<Books> books;
}
