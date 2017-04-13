package bookStore.service;

import bookStore.dto.AuthorDTO;
import bookStore.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

public class CachingAuthorService implements AuthorService {
    private AuthorService origin;

    public CachingAuthorService(AuthorService origin) {
        this.origin = origin;
    }

    @Override
    public List<Author> getAll() {
        //TODO: Add caching
        return origin.getAll();
    }

    @Override
    public Author findById(int authorId) {
        //TODO: Add caching
        return origin.findById(authorId);
    }

    @Override
    public Author create(AuthorDTO authorDTO) {
        return origin.create(authorDTO);
    }
}
