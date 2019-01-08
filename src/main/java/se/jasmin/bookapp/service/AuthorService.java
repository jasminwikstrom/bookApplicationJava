package se.jasmin.bookapp.service;

import se.jasmin.bookapp.api.dto.AuthorDto;
import se.jasmin.bookapp.repository.entity.Author;


public interface AuthorService {


    Author saveAuthor(AuthorDto author);
}





