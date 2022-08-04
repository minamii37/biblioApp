package com.example.biblioapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.biblioapp.repository.entity.BookEntity;

public interface BookRepositoryJpa extends JpaRepository<BookEntity, Integer> {
}
