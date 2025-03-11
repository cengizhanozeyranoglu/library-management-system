package com.ozeyranoglucengizhan.library_management_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
@Table(name = "category")
public class Category extends BaseEntity {

    @Column(name = "category_name")
    private String categoryName;

    @ManyToMany(mappedBy = "category")
    private List<Books> books;
}
