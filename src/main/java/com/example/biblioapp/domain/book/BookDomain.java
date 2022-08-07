package com.example.biblioapp.domain.book;

import lombok.Getter;


import java.time.LocalDate;

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
        this.bookId = bookId;
        this.bookName = bookName;
        this.isbn13 = isbn13;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public void checkForSaving (){
        if (bookName == null || bookName.isEmpty() || bookName.isBlank()){
            throw new IllegalArgumentException("本のタイトルは必須入力項目です");
        }
        if (isbn13 == null || isbn13.isEmpty() || isbn13.isBlank()){
            throw new IllegalArgumentException("ISBN13は必須入力項目です");
        }
        if (author == null || author.isEmpty() || author.isBlank()){
            throw new IllegalArgumentException("著者名は必須入力項目です");
        }
        if (publisher == null || publisher.isEmpty() || publisher.isBlank()){
            throw new IllegalArgumentException("出版社は必須入力項目です");
        }
        if (publicationDate == null) {
            throw new IllegalArgumentException("出版日は必須入力項目です");
        }
    }
}
