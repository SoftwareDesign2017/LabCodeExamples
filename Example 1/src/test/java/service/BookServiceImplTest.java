package service;

import model.Book;
import model.builder.BookBuilderImpl;
import org.junit.Before;
import org.junit.Test;
import repository.BookRepositoryMockImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 07/03/2017.
 */
public class BookServiceImplTest {

    private BookService bookService;

    @Before
    public void setup() {
        bookService = new BookServiceImpl(new BookRepositoryMockImpl());
    }

    @Test
    public void findAll() throws Exception {
        assertEquals(bookService.findAll().size(), 10);
    }

    @Test
    public void findById() throws Exception {
        Long id = 1L;
        assertTrue(bookService.findById(id).getId().equals(id));
    }

    @Test
    public void save() throws Exception {
        assertFalse(bookService.save(new Book()));
    }

}