package com.example.biblioapp.application.bookservice;

import com.example.biblioapp.application.ResponseModel;
import com.example.biblioapp.domain.book.BookDomain;
import com.example.biblioapp.domain.repository.IBookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.*;

@Service
public class BookService implements IBookService{
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public ResponseModel<BookViewModel> addNewBook (BookViewModel view) {
        var domain = createNewBookDomainFromView(view);
        try{
            domain.checkForSaving();
            bookRepository.save(domain);
        } catch (Exception e) {
//            HACK:メッセージだけじゃなく、param返却する自作例外を作成して、不正理由を明確にしたい
//            Map<String, String> map = new HashMap<>();
//            map.put( "Message", e.getMessage());
//            map.put( "param", "aaa" );
            return new ResponseModel<>(
                    new ArrayList<>(),
                    ResponseEntity.badRequest().body(e.getMessage())
            );
        }

        var resViewList = new ArrayList<BookViewModel>();
        resViewList.add(new BookViewModel().fromDomain(domain));
//        Map<String, String> map = new HashMap<>();
//        map.put( "Message", "");
        return new ResponseModel<>(
                resViewList,
                ResponseEntity.ok().body("")
        );
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

    @Override
    public String getBookImagePath(String isbn13){
        var domain = new BookDomain(isbn13);
        domain.getBookImg();
        return domain.getBookImgPath();
    }

    private BookDomain createNewBookDomainFromView(BookViewModel view){
        return new BookDomain(
                UUID.randomUUID().toString(),
                view.getName(),
                view.getIsbn13(),
                view.getAuthor(),
                view.getPublisher(),
                view.getPublicationDate(),
                "");
    }
}
