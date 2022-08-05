package com.example.biblioapp.application.bookservice;

import com.example.biblioapp.domain.book.BookDomain;
import com.example.biblioapp.domain.repository.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

@Service
public class BookService implements IBookService{
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public String addNewBook (BookViewModel view) {
        var domain1 = new BookDomain(
                UUID.randomUUID().toString());
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
        views.sort(Comparator.comparing((BookViewModel::getName)));

        return views;
    }

    private BookDomain createNewBookDomainFromView(){

    }
}
