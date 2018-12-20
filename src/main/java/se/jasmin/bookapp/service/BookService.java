package se.jasmin.bookapp.service;

import se.jasmin.bookapp.model.BookDto;
import se.jasmin.bookapp.modelEntity.Book;

import java.util.List;


public interface BookService {
    Book saveBook(BookDto book);

    List<Book> getBooks(String title, String author);

    Book updateBook(Long id, BookDto bookDto);
}


