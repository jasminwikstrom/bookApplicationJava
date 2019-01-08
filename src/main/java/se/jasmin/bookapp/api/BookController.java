package se.jasmin.bookapp.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jasmin.bookapp.api.dto.AuthorDto;
import se.jasmin.bookapp.api.dto.CategoryDto;
import se.jasmin.bookapp.api.dto.CreateNewBookDto;
import se.jasmin.bookapp.api.dto.UpdateBookDto;
import se.jasmin.bookapp.repository.entity.Author;
import se.jasmin.bookapp.repository.entity.Book;
import se.jasmin.bookapp.repository.entity.Category;
import se.jasmin.bookapp.service.AuthorService;
import se.jasmin.bookapp.service.BookService;
import se.jasmin.bookapp.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    CategoryService categoryService;


    @PostMapping("/authors")
    public Author addAuthor(@RequestBody AuthorDto authorDto) {

        Author save = authorService.saveAuthor(authorDto);

        return ResponseEntity.ok(save).getBody();
    }


    @PostMapping("/categories")
    public Category addCategory(@RequestBody CategoryDto categoryDto) {

        Category save = categoryService.saveCategory(categoryDto);

        return ResponseEntity.ok(save).getBody();
    }


    @PostMapping
    public Book createNewBook(@RequestBody CreateNewBookDto createNewBookDto) {

        Book save = bookService.saveBook(createNewBookDto);

        return ResponseEntity.ok(save).getBody();
    }


    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "author", required = false) String author) {

        var books = bookService.getBooks(title, author);

        return books.size() > 0
                ? ResponseEntity.ok(books)
                : ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity updateBookById(@PathVariable(value = "id") String id, @RequestBody UpdateBookDto bookDto) {
        var optionalBook = bookService.updateBook(id, bookDto);

        if (optionalBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(optionalBook.get());
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long id) {
        var deleteBookId = bookService.deleteBookById(id);

        if (deleteBookId.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(deleteBookId.get());
        }
    }
}

