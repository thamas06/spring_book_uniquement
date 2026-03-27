package com.testspring_boot.testspring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testspring_boot.testspring_boot.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
