package repository;

import model.Book;
import model.builder.BookBuilderImpl;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utility.JDBConnectionWrapper;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 07/03/2017.
 */
public class BookRepositoryMySQLTest {

    private static BookRepository bookRepository;
    private static JDBConnectionWrapper jdbConnectionWrapper;

    @BeforeClass
    public static void setUp() {
        jdbConnectionWrapper = new JDBConnectionWrapper();
        bookRepository = new BookRepositoryCacheDecorator(new BookRepositoryMySQL(jdbConnectionWrapper.getConnection()), new Cache<>());
    }

    @Before
    public void cleanUp() throws Exception {
        bookRepository.deleteAll();
    }

    @Test
    public void testConnection() throws SQLException {
        assertTrue(jdbConnectionWrapper.testConnection());
    }

    @Test
    public void findAll() throws Exception {
        List<Book> books = bookRepository.findAll();
        books = bookRepository.findAll();
        books = bookRepository.findAll();
        books = bookRepository.findAll();
        books = bookRepository.findAll();
        assertTrue(books.size() == 0);

        bookRepository.save(new BookBuilderImpl()
                .setId(0L)
                .setAuthor("Author")
                .setTitle("Title")
                .setPublishedDate(new DateTime())
                .build());

        books = bookRepository.findAll();

        assertTrue(books.size() == 1);
    }

    @Test
    public void findById() throws Exception {

    }

    @Test
    public void deleteAll() throws Exception {
        bookRepository.save(new BookBuilderImpl()
                .setAuthor("Author")
                .setTitle("Title")
                .setPublishedDate(new DateTime())
                .build());
        bookRepository.save(new BookBuilderImpl()
                .setAuthor("Author")
                .setTitle("Title")
                .setPublishedDate(new DateTime())
                .build());
        bookRepository.save(new BookBuilderImpl()
                .setAuthor("Author")
                .setTitle("Title")
                .setPublishedDate(new DateTime())
                .build());
        assertTrue(bookRepository.findAll().size() == 3);

        bookRepository.deleteAll();
        assertTrue(bookRepository.findAll().size() == 0);
    }

    @Test
    public void save() throws Exception {
        assertTrue(bookRepository.save(new BookBuilderImpl()
                .setAuthor("Author")
                .setTitle("Title")
                .setPublishedDate(new DateTime())
                .build()));
    }

}