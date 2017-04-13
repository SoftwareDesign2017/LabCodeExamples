package bookStore.service;

import bookStore.dto.AuthorDTO;
import bookStore.entity.Author;
import bookStore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Catalysts on 9/9/2015.
 */
public class AuthorServiceImpl implements AuthorService{
    AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(int authorId) {
        return authorRepository.findOne(authorId);
    }

    @Override
    public Author create(AuthorDTO authorDTO) {
        return authorRepository.save(new Author(authorDTO.name));
    }
}
