package se.jasmin.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jasmin.bookapp.api.dto.AuthorDto;
import se.jasmin.bookapp.repository.AuthorRepository;
import se.jasmin.bookapp.repository.entity.Author;


@Service
public class AuthorServiceImpl implements AuthorService {


    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author saveAuthor(AuthorDto authorDto) {

        if (authorDto.getName() == null) {
            throw new RuntimeException("Name can not be null");

        }

        if (authorDto.getAboutAuthor() == null) {
            throw new RuntimeException("About Author can not be null");
        }


        var author = new Author();
        author.setName(authorDto.getName());
        author.setAboutAuthor(authorDto.getAboutAuthor());

        return authorRepository.save(author);
    }
}





