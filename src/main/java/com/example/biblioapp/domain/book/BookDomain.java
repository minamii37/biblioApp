package com.example.biblioapp.domain.book;

import lombok.Data;
import lombok.Getter;


import java.time.LocalDate;
import java.util.UUID;

@Getter
public class BookDomain {
    private String bookId;

    private String bookName;

    private String isbn13;

    private String author;

    private String publisher;

    private LocalDate publicationDate;

    public BookDomain(String bookId,
                      String bookName,
                      String isbn13,
                      String author,
                      String publisher,
                      LocalDate publicationDate){
        // IDの指定がない場合は、IDを割り振る
        if(bookId == null || bookId.isEmpty()){
            this.bookId = UUID.randomUUID().toString();
        } else{
            this.bookId = bookId;
        }
        this.bookName = bookName;
        this.isbn13 = isbn13;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }
}
