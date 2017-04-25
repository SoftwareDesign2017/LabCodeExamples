package example6

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.joda.time.DateTime
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Author)
@Mock([Author, Book])
class AuthorSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test author validation"() {
        when: "we have an invalid author"
        def author = new Author().with {
            it.name = "Author Name"
            it
        }

        then: "the author should be invalid"
        !author.validate()
        author.errors.errorCount == 1

        when: "we have a valid author"
        author = author.with {
            it.dateOfBirth = new DateTime()
            it
        }

        then: "the author should be valid"
        author.validate()

        when: "I try to fetch it without saving"
        def authors = Author.findAll()

        then: "it should not be there"
        authors.isEmpty()

        when: "I save it"
        author.save()
        authors = Author.findAll()

        then: "after fetching all authors, it should be there"
        authors.size() == 1
    }

    void "test adding books to author"() {
        given: "a valid and persisted author"
        def author = new Author().with {
            it.name = "Author Name"
            it.dateOfBirth = new DateTime()
            it
        }
        author.save()

        when: "I add invalid books to the author"
        author.addToBooks(new Book())
        author.save()

        then: "by fetching the author, the book should not be valid"
        !Author.findAll().first().books.first().validate()
        Book.findAll().isEmpty()

        when: "adding a valid book"
        author.addToBooks(new Book().with {
            it.title = "Book title"
            it
        }.save())
        author.save()

        then: "by fetching the author, the books should be there and be valid"
        !Author.findAll().first().books.isEmpty()
        Author.findAll().first().books.last().validate()
        Author.findAll().first().books.size() == 2
        Book.findAll().size() == 1

    }
}
