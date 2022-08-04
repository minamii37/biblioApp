package com.example.biblioapp.repository.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class BookEntity {
    @Id
    private String bookId;

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String isbn13;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;

    protected BookEntity () {
    }

    public BookEntity (String bookId,
                       String bookName,
                       String isbn13,
                       String author,
                       String publisher,
                       LocalDate publicationDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.isbn13 = isbn13;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }
}
