package com.example.biblioapp.application.bookservice;

import com.example.biblioapp.domain.book.BookDomain;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class BookViewModel {
    private String id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String isbn13;

    @NotNull
    @NotBlank
    private String author;

    @NotNull
    @NotBlank
    private String publisher;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;

    public BookViewModel(){
    }

    public BookViewModel (String id,
                          String name,
                          String isbn13,
                          String author,
                          String publisher,
                          LocalDate publicationDate) {
        this.id = id;
        this.name = name;
        this.isbn13 = isbn13;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public BookViewModel fromDomain(BookDomain domain){
        this.id = domain.getBookId();
        this.name = domain.getBookName();
        this.isbn13 = domain.getIsbn13();
        this.author = domain.getAuthor();
        this.publisher = domain.getPublisher();
        this.publicationDate = domain.getPublicationDate();

        return this;
    }

    public BookDomain fromView(){
        return new BookDomain(
                this.id,
                this.name,
                this.isbn13,
                this.author,
                this.publisher,
                this.publicationDate);
    }
}
