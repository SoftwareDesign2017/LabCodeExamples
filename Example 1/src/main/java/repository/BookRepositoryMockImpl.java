package repository;

import model.Book;
import model.builder.BookBuilderImpl;
import org.joda.time.DateTime;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Created by Alex on 07/03/2017.
 */
public class BookRepositoryMockImpl implements BookRepository {

    public List<Book> findAll() {
        return LongStream.range(0, 10).mapToObj(i -> new BookBuilderImpl()
                .setId(i)
                .setAuthor(String.valueOf(i))
                .setPublishedDate(new DateTime())
                .setTitle(String.valueOf(i) + " - " + String.valueOf(i))
                .build()
        ).collect(Collectors.toList());
    }

    public Book findById(Long id) {
        return new BookBuilderImpl().setId(id).build();
    }

    public boolean save(Book book) {
        return false;
    }

    @Override
    public void deleteAll() {

    }
}
