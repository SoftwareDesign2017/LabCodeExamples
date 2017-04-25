package example6

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.joda.time.DateTime
import org.joda.time.LocalDate
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(BookService)
@Mock([Author, Book])
class BookServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test book publishing"() {
        given: "an unpublished book and author"
        Book book = new Book().with {
            it.title = "Title!"
            it
        }
        book.save()
        Author author = new Author().with {
            it.name = "Author name"
            it
        }
        author.save()

        when: "we publish the book"
        service.publishBook(book, new LocalDate(), author)

        then: "the book should be published and the author should have the book"
        book.isPublished()
        author.books.size() == 1
    }

    void "test book author change"() {
        given: "two authors and a book"
        service.authorService = Mock(AuthorService)

        def author1 = new Author().with {
            it.name = "Author 1"
            it.dateOfBirth = new Date()
            it
        }.save()

        def author2 = new Author().with {
            it.name = "Author 2"
            it.dateOfBirth = new Date()
            it
        }.save()

        def book = new Book().with {
            it.title = "Book title"
            it.author = author1
            it.dateOfPublishing = new DateTime()
            it
        }.save()

        1 * service.authorService.findById(author2.id) >> author2 // mocking a return with Spock! - needed as it is a unit test

        when: "I change the author of the book"
        service.changeAuthor(book, author2.id)

        then: "the book should have a new author and the previous author should have no book"
        book.author.id == author2.id
        author2.books.contains(book)
        !author1.books.contains(book)

    }
}
