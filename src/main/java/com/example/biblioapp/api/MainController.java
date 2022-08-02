package com.example.biblioapp.api;

import com.example.biblioapp.domain.bookModel.BookModel;
import com.example.biblioapp.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/biblioApp")
public class MainController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewBook(@RequestParam String name,
                                           @RequestParam String isbn){
        BookModel book = new BookModel();
        book.setName(name);
        book.setISBN(isbn);
        bookRepository.save(book);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }
}
