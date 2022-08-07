package com.example.biblioapp.application.bookservice;

import com.example.biblioapp.domain.book.BookDomain;
import com.example.biblioapp.domain.repository.IBookRepository;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.UUID;

@Service
public class BookService implements IBookService{
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public String addNewBook (BookViewModel view) {
        var domain = createNewBookDomainFromView(view);
        domain.checkForSaving();
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

        // 日本語のロケールで並べ替え
        Collator collator = Collator.getInstance(Locale.JAPAN);
        views.sort(Comparator.comparing((BookViewModel::getName), collator));

        return views;
    }

    private BookDomain createNewBookDomainFromView(BookViewModel view){
        return new BookDomain(
                UUID.randomUUID().toString(),
                view.getName(),
                view.getIsbn13(),
                view.getAuthor(),
                view.getPublisher(),
                view.getPublicationDate());
    }
}
