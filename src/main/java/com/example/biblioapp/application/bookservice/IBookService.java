package com.example.biblioapp.application.bookservice;

import java.util.ArrayList;

public interface IBookService {
    String addNewBook (BookViewModel view);
    ArrayList<BookViewModel> getAllBooks ();
}
