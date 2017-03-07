package service;

import model.Book;
import repository.BookRepository;

import java.util.List;

/**
 * Created by Alex on 07/03/2017.
 */
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean save(Book book) {
        return repository.save(book);
    }

}
