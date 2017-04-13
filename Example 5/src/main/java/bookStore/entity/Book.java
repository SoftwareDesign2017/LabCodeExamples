package bookStore.entity;

import javax.persistence.*;

/**
 * Created by Catalysts on 8/9/2015.
 */
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String isbn;
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Author author;

    public Book(String name, Author author, String isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    private Book() {}

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
