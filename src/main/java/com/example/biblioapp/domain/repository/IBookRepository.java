package com.example.biblioapp.domain.repository;

import com.example.biblioapp.domain.book.BookDomain;

import java.util.ArrayList;

public interface IBookRepository {
    ArrayList<BookDomain> getBooks();

    void save(BookDomain bookDomain);
}
