package se.jasmin.bookapp.api;


import org.springframework.web.bind.annotation.*;
import se.jasmin.bookapp.model.AuthorDto;
import se.jasmin.bookapp.model.BookDto;
import se.jasmin.bookapp.model.CategoryDto;
import se.jasmin.bookapp.modelEntity.Author;
import se.jasmin.bookapp.modelEntity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import se.jasmin.bookapp.modelEntity.Category;
import se.jasmin.bookapp.service.AuthorService;
import se.jasmin.bookapp.service.BookService;
import se.jasmin.bookapp.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookAppController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired CategoryService categoryService;



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
    public Book CreateNewBook(@RequestBody BookDto bookDto) {

        Book save = bookService.saveBook(bookDto);

        return ResponseEntity.ok(save).getBody();
    }


    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "author", required = false) String author) {

        List<Book> books = bookService.getBooks(title,author);

        return books.size() > 0
                ? ResponseEntity.ok(books)
                : ResponseEntity.notFound().build();
    }



    @PutMapping("/{id}")
    public ResponseEntity updateBookById(@PathVariable(value = "id") Long id, @RequestBody BookDto bookDto)  {
        Book book = bookService.updateBook(id, bookDto);
        return ResponseEntity.ok(book);
    }


    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable("id") Long id)  {
        bookService.deleteBookById(id);




    }
}

