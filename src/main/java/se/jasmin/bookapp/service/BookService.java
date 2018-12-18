package se.jasmin.bookapp.service;

import se.jasmin.bookapp.model.BookDto;
import se.jasmin.bookapp.modelEntity.Book;


public interface BookService {
    Book saveBook(BookDto book);
}


