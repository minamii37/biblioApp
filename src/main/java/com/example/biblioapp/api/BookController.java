package com.example.biblioapp.api;

import com.example.biblioapp.application.bookservice.BookViewModel;
import com.example.biblioapp.application.bookservice.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/biblioApp/book")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    private final IBookService bookService;

    public BookController (IBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewBook(@RequestBody @Validated BookViewModel view){
        return bookService.addNewBook(view);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<BookViewModel> getAllBooks() {
        return bookService.getAllBooks();
    }
}
