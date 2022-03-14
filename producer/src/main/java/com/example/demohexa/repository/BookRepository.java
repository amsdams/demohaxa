package com.example.demohexa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demohexa.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
