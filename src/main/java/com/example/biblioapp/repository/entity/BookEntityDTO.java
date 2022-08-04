package com.example.biblioapp.repository.entity;

import com.example.biblioapp.domain.book.BookDomain;

public class BookEntityDTO {
    public static BookEntity fromDomain(BookDomain bookDomain){
        return new BookEntity(
                bookDomain.getBookId(),
                bookDomain.getBookName(),
                bookDomain.getIsbn13(),
                bookDomain.getAuthor(),
                bookDomain.getPublisher(),
                bookDomain.getPublicationDate());
    }

    public static BookDomain fromEntity(BookEntity bookEntity){
        return new BookDomain(
                bookEntity.getBookId(),
                bookEntity.getBookName(),
                bookEntity.getIsbn13(),
                bookEntity.getAuthor(),
                bookEntity.getPublisher(),
                bookEntity.getPublicationDate());
    }
}
