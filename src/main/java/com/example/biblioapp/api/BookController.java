package com.example.biblioapp.api;

import com.example.biblioapp.api.viewmodel.BookViewModel;
import com.example.biblioapp.domain.book.BookEntity;
import com.example.biblioapp.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(path = "/biblioApp/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewBook(@RequestBody @Validated BookViewModel view){
        BookEntity book = new BookEntity();
        book.setId(UUID.randomUUID().toString());
        book.setName(view.getName());
        book.setIsbn13(view.getIsbn13());
        book.setAuthor(view.getAuthor());
        book.setPublisher(view.getPublisher());
        book.setPublicationDate(view.getPublicationDate());
        bookRepository.save(book);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<BookEntity> getAllBooks() {
        return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
