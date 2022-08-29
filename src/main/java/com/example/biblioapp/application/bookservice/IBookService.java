package com.example.biblioapp.application.bookservice;

import com.example.biblioapp.application.ResponseModel;
import java.util.ArrayList;

public interface IBookService {
    ResponseModel<BookViewModel> addNewBook (BookViewModel view);
    ArrayList<BookViewModel> getAllBooks();
    String getBookImagePath(String isbn13);
}
