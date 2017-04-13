package bookStore.repository;

import bookStore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Catalysts on 9/9/2015.
 */
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
