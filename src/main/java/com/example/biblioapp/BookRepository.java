package com.example.biblioapp;

import org.springframework.data.repository.CrudRepository;

import com.example.biblioapp.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
