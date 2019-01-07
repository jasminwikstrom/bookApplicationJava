package se.jasmin.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jasmin.bookapp.model.BookDto;

import se.jasmin.bookapp.modelEntity.Book;
import se.jasmin.bookapp.repository.AuthorRepository;
import se.jasmin.bookapp.repository.BookRepository;
import se.jasmin.bookapp.repository.CategoryRepository;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Book saveBook(BookDto bookDto) {

        if (bookDto.getTitle() == null) {
            throw new RuntimeException("Title can not be null");

        }

        if (bookDto.getAuthorId() == null) {
            throw new RuntimeException("Author can not be null");
        }


        var author = authorRepository.findById(Long.valueOf(bookDto.getAuthorId()));

        if (author.isEmpty()) {
            throw new RuntimeException("Author does not exist");
        }

        if (bookDto.getCategoryId() == null) {
            throw new RuntimeException("Category can not be null");
        }
        var category = categoryRepository.findById(Long.valueOf(bookDto.getCategoryId()));

        if (category.isEmpty()){
            throw new RuntimeException("Category does not exist");

        }

        var book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(author.get());
        book.setCategory(category.get());
        book.setDescription(bookDto.getDescription());
        book.setYear(bookDto.getYear());


        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks(String title, String author) {

        List<Book> books = bookRepository.findByQuery(title, author);

        return books;

    }


    public Book updateBook(Long id, BookDto bookDto) {
        Book foundBook = bookRepository.findById(id).get();
        foundBook.setDescription(bookDto.getDescription());



        return bookRepository.save(foundBook);
    }



    @Override
    public void deleteBookById(Long id) {
        bookRepository.findById(id).ifPresent(bookRepository::delete);


    }

}





