package com.ozeyranoglucengizhan.library_management_system.repository;

import com.ozeyranoglucengizhan.library_management_system.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
}
