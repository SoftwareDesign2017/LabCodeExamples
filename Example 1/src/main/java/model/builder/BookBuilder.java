package model.builder;

import model.Book;
import org.joda.time.DateTime;

/**
 * Created by Alex on 07/03/2017.
 */
public interface BookBuilder {

    BookBuilder setAuthor(String author);

    BookBuilder setTitle(String title);

    BookBuilder setPublishedDate(DateTime publishedDate);

    BookBuilder setId(Long id);

    Book build();
}
