package bookStore.repository;

import bookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Catalysts on 8/9/2015.
 */

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByName(String name);
}