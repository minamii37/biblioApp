package com.example.biblioapp.repository;

import com.example.biblioapp.domain.book.BookDomain;
import com.example.biblioapp.domain.repository.IBookRepository;
import com.example.biblioapp.repository.entity.BookEntityDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BookRepositoryImpl implements IBookRepository {
    private final BookRepositoryJpa bookRepositoryJpa;

    public BookRepositoryImpl(BookRepositoryJpa bookRepositoryJpa){
        this.bookRepositoryJpa = bookRepositoryJpa;
    }

    public ArrayList<BookDomain> getBooks(){
        var books = bookRepositoryJpa.findAll();
        var bookDomains = new ArrayList<BookDomain>();
        books.forEach(x -> bookDomains.add(BookEntityDTO.fromEntity(x)));
        return bookDomains;
    }

    @Override
    public void save (BookDomain domain) {
        var entity = BookEntityDTO.fromDomain(domain);
        bookRepositoryJpa.save(entity);
    }
}
