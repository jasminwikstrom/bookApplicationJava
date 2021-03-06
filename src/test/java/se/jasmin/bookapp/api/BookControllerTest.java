package se.jasmin.bookapp.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.jasmin.bookapp.api.dto.AuthorDto;
import se.jasmin.bookapp.api.dto.CategoryDto;
import se.jasmin.bookapp.api.dto.CreateNewBookDto;
import se.jasmin.bookapp.api.dto.UpdateBookDto;
import se.jasmin.bookapp.repository.AuthorRepository;
import se.jasmin.bookapp.repository.BookRepository;
import se.jasmin.bookapp.repository.CategoryRepository;
import se.jasmin.bookapp.repository.entity.Book;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookController bookController;

    @Before
    public void cleanDb() {
        bookRepository.deleteAll();
        categoryRepository.deleteAll();
        authorRepository.deleteAll();

    }

    @Test
    public void createNewBook() {

        //Assert that there are no Books in repo
        var allBooks = bookController.getAllBooks(null, null);
        Assert.assertEquals(404, allBooks.getStatusCodeValue());
        Assert.assertNull(allBooks.getBody());

        var createdBook = createBookAndAuthorAndCategory();

        Assert.assertNotNull(createdBook);
        Assert.assertEquals("bra bok", createdBook.getTitle());
        Assert.assertEquals("bra beskrivning", createdBook.getDescription());
        Assert.assertEquals("2001", createdBook.getYear());
        Assert.assertEquals("skräckis", createdBook.getCategory().getText());
        Assert.assertEquals("bra Författare", createdBook.getAuthor().getName());

        var getAllBooks = bookController.getAllBooks(null, null);

        Assert.assertNotNull(getAllBooks);
        Assert.assertNotNull(getAllBooks.getBody());
        Assert.assertEquals(1, getAllBooks.getBody().size());

    }

    @Test
    public void updateBookById() {

        var createdBook = createBookAndAuthorAndCategory();
        Assert.assertEquals("bra beskrivning", createdBook.getDescription());

        var updateBookDto = new UpdateBookDto();
        updateBookDto.setDescription("ny beskrivning");

        var response = bookController.updateBookById(createdBook.getId().toString(), updateBookDto);

        var updatedBook = (Book) response.getBody();
        Assert.assertEquals("ny beskrivning", updatedBook.getDescription());
    }

    @Test
    public void updateBookByIdNullDescriptionShouldNotChange() {

        var createdBook = createBookAndAuthorAndCategory();
        Assert.assertEquals("bra beskrivning", createdBook.getDescription());

        var updateBookDto = new UpdateBookDto();
        updateBookDto.setDescription(null);

        var response = bookController.updateBookById(createdBook.getId().toString(), updateBookDto);

        var updatedBook = (Book) response.getBody();
        Assert.assertEquals("bra beskrivning", updatedBook.getDescription());
    }


    @Test
    public void deleteById() {

        var createdBook = createBookAndAuthorAndCategory();
        var listofbooks = bookController.getAllBooks(null, null);
        Assert.assertEquals(1, listofbooks.getBody().size());

        var deletedId = bookController.deleteBookById(createdBook.getId());
        Assert.assertEquals(createdBook.getId().toString(), deletedId.getBody());

        listofbooks = bookController.getAllBooks(null, null);
        Assert.assertNull(listofbooks.getBody());
        Assert.assertEquals(404, listofbooks.getStatusCodeValue());
    }

    @Test
    public void deleteByIncorrectId() {

        var createdBook = createBookAndAuthorAndCategory();
        var listofbooks = bookController.getAllBooks(null, null);

        var incorrectId = bookController.deleteBookById(17L);
        Assert.assertNull(createdBook.getId().toString(), incorrectId.getBody());
        Assert.assertEquals(404, incorrectId.getStatusCodeValue());
        Assert.assertEquals(1, listofbooks.getBody().size());

    }


    private Book createBookAndAuthorAndCategory() {

        //Add a new Author and save in repo
        var authorDto = new AuthorDto();
        authorDto.setName("bra Författare");
        authorDto.setAboutAuthor("bra författare");

        var addedAuthor = bookController.addAuthor(authorDto);

        //Add a new Category and save in repo
        var categoryDto = new CategoryDto();
        categoryDto.setText("skräckis");

        var addedCategory = bookController.addCategory(categoryDto);

        var bookDto = new CreateNewBookDto();
        bookDto.setAuthorId(addedAuthor.getId().toString());
        bookDto.setCategoryId(addedCategory.getId().toString());
        bookDto.setDescription("bra beskrivning");
        bookDto.setTitle("bra bok");
        bookDto.setYear("2001");

        return bookController.createNewBook(bookDto);
    }
}