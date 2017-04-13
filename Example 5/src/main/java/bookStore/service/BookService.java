package bookStore.service;

import bookStore.dto.BookDto;
import bookStore.entity.Book;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Catalysts on 8/9/2015.
 */

public interface BookService {
    List<Book> getAll();
    Book create(BookDto book);
}
