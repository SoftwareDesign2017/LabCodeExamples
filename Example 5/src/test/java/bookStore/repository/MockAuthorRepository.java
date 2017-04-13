package bookStore.repository;

import bookStore.entity.Author;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.thymeleaf.expression.Lists;

import java.util.Arrays;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

public class MockAuthorRepository implements AuthorRepository {
    @Override
    public <S extends Author> S save(S s) {
        return null;
    }

    @Override
    public Author findOne(Integer integer) {
        return null;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public List<Author> findAll() {
        return Arrays.asList(new Author("ion"), new Author("vasile"));
    }

    @Override
    public List<Author> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Author> findAll(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void delete(Author author) {

    }

    @Override
    public void delete(Iterable<? extends Author> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(Iterable<Author> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Author getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Author> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Author> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Author> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Author> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends Author> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Author> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Author> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Author> boolean exists(Example<S> example) {
        return false;
    }
}
