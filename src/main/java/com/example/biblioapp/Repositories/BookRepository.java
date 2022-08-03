package com.example.biblioapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.biblioapp.domain.book.BookEntity;
import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findAll();
}
