package com.example.biblioapp.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.biblioapp.domain.bookModel.BookModel;

public interface BookRepository extends CrudRepository<BookModel, Integer> {
}
