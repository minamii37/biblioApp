package com.example.biblioapp.api;

import com.example.biblioapp.domain.book.BookEntity;
import com.example.biblioapp.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping(path = "/biblioApp/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewBook(@RequestParam String name,
                                           @RequestParam String isbn13,
                                           @RequestParam String author,
                                           @RequestParam String publisher,
                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate publicationDate){
        BookEntity book = new BookEntity();
        book.setId(UUID.randomUUID().toString());
        book.setName(name);
        book.setIsbn13(isbn13);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setPublicationDate(publicationDate);
        bookRepository.save(book);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<BookEntity> getAllBooks() {
        return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
