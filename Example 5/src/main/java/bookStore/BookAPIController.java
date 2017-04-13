package bookStore;

import bookStore.dto.BookDto;
import bookStore.entity.Book;
import bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Catalysts on 8/9/2015.
 */
@RestController
public class BookAPIController {
    @Autowired
    BookService service;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Book create(@RequestBody @Valid BookDto book) {
        return service.create(book);
    }
}
