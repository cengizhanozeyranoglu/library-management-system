package com.ozeyranoglucengizhan.library_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedBooks extends JpaRepository<BorrowedBooks, Long> {
}
