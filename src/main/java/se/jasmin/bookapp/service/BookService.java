package se.jasmin.bookapp.service;

import se.jasmin.bookapp.api.dto.CreateNewBookDto;
import se.jasmin.bookapp.api.dto.UpdateBookDto;
import se.jasmin.bookapp.repository.entity.Book;

import java.util.List;
import java.util.Optional;


public interface BookService {
    Book saveBook(CreateNewBookDto createNewBookDto);

    List<Book> getBooks(String title, String author);

    Optional<Book> updateBook(String id, UpdateBookDto updateBookDto);

    Optional<String> deleteBookById(Long id);
}


