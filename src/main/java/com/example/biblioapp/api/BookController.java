package com.example.biblioapp.api;

import com.example.biblioapp.application.ResponseModel;
import com.example.biblioapp.application.bookservice.BookViewModel;
import com.example.biblioapp.application.bookservice.IBookService;
import org.springframework.stereotype.Controller;
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
    public @ResponseBody ResponseModel<BookViewModel> addNewBook(@RequestBody BookViewModel view){
        return bookService.addNewBook(view);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<BookViewModel> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "/img")
    public @ResponseBody String getBookImagePath(@RequestParam("isbn13") String isbn13) {
        return bookService.getBookImagePath(isbn13);
    }
}
