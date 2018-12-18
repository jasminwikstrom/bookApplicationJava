package se.jasmin.bookapp.api;


import org.springframework.web.bind.annotation.RequestBody;
import se.jasmin.bookapp.model.BookDto;
import se.jasmin.bookapp.modelEntity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import se.jasmin.bookapp.service.BookService;

@RestController
public class BookappController {

    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public Book addBook(@RequestBody BookDto bookDto) {

        Book save = bookService.saveBook(bookDto);

        return ResponseEntity.ok(save).getBody();
    }
}

