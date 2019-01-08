package se.jasmin.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jasmin.bookapp.api.dto.CreateNewBookDto;
import se.jasmin.bookapp.api.dto.UpdateBookDto;
import se.jasmin.bookapp.repository.AuthorRepository;
import se.jasmin.bookapp.repository.BookRepository;
import se.jasmin.bookapp.repository.CategoryRepository;
import se.jasmin.bookapp.repository.entity.Book;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Book saveBook(CreateNewBookDto createNewBookDto) {

        if (createNewBookDto.getTitle() == null) {
            throw new RuntimeException("Title can not be null");
        }

        if (createNewBookDto.getAuthorId() == null) {
            throw new RuntimeException("Author can not be null");
        }

        var author = authorRepository.findById(Long.valueOf(createNewBookDto.getAuthorId()));

        if (author.isEmpty()) {
            throw new RuntimeException("Author does not exist");
        }

        if (createNewBookDto.getCategoryId() == null) {
            throw new RuntimeException("Category can not be null");
        }
        var category = categoryRepository.findById(Long.valueOf(createNewBookDto.getCategoryId()));

        if (category.isEmpty()) {
            throw new RuntimeException("Category does not exist");

        }

        var book = new Book();
        book.setTitle(createNewBookDto.getTitle());
        book.setAuthor(author.get());
        book.setCategory(category.get());
        book.setDescription(createNewBookDto.getDescription());
        book.setYear(createNewBookDto.getYear());

        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks(String title, String author) {

        List<Book> books = bookRepository.findByQuery(title, author);
        return books;
    }

    @Override
    public Optional<Book> updateBook(String id, UpdateBookDto updateBookDto) {
        Optional<Book> foundBook = bookRepository.findById(Long.parseLong(id));

        return foundBook.map(book -> {

            if (updateBookDto.getDescription() != null) {
                book.setDescription(updateBookDto.getDescription());
                return bookRepository.save(book);
            }
            return book;
        });
    }


    @Override
    public Optional<String> deleteBookById(Long id) {

        var bookToDelete = bookRepository.findById(id);

        return bookToDelete.map(book -> {
            bookRepository.findById(id).ifPresent(bookRepository::delete);
            return book.getId().toString();
        });
    }

}





