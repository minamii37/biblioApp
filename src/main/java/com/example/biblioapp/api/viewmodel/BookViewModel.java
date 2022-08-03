package com.example.biblioapp.api.viewmodel;

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
}
