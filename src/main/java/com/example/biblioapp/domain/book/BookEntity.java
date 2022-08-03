package com.example.biblioapp.domain.book;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class BookEntity {
    @Id
    private String id;

    private String name;

    private String isbn13;

    private String author;

    private String publisher;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;
}
