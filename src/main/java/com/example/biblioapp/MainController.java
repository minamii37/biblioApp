package com.example.biblioapp;

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
        Book book = new Book();
        book.setName(name);
        book.setISBN(isbn);
        bookRepository.save(book);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
