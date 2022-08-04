package com.example.biblioapp.application.bookservice;

import com.example.biblioapp.domain.repository.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService implements IBookService{
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public String addNewBook (BookViewModel view) {
        var domain = view.fromView();
        bookRepository.save(domain);

        return "Saved";
    }

    @Override
    public ArrayList<BookViewModel> getAllBooks () {
        var bookDomains = bookRepository.getBooks();
        var views = new ArrayList<BookViewModel>();
        bookDomains.forEach(x -> {
            var view = new BookViewModel();
            views.add(view.fromDomain(x));
        });

        return views;
    }

}
