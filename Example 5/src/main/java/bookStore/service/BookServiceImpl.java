package bookStore.service;

import bookStore.dto.BookDto;
import bookStore.entity.Author;
import bookStore.entity.Book;
import bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Catalysts on 8/9/2015.
 */
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private AuthorService authorService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, @Value("${bookService.maxBooks}") Integer maxBooks) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        System.out.println(maxBooks);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book create(BookDto bookDto) {
        Author a = authorService.findById(bookDto.authorId);
        Book b = new Book(bookDto.name, a, bookDto.isbn);
        return bookRepository.save(b);
    }

}
