package com.ozeyranoglucengizhan.library_management_system.repository;

import com.ozeyranoglucengizhan.library_management_system.entity.ReturnBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnBookRepository extends JpaRepository<ReturnBooks, Long> {
}
