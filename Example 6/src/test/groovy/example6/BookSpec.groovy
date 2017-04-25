package example6

import grails.test.mixin.TestFor
import org.joda.time.DateTime
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
class BookSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test book validation"() {
        when: "we have an invalid book"
        Book book = new Book().with {
            it.title = null
            it.dateOfPublishing = null
            it
        }
        then: "the book should be invalid"
        !book.validate()
        book.getErrors().errorCount == 1

        when: "we create a valid book"
        book = new Book().with {
            it.title = "title"
            it.dateOfPublishing = null
            it
        }

        then: "the book is to be valid"
        book.validate()
        !book.isPublished()

        when: "we publish the book"
        book = book.with {
            it.dateOfPublishing = new DateTime()
            it
        }
        then: "the book should be marked as published but should be invalid due to the lack of author"
        !book.validate()
        book.isPublished()

        when: "we assign an author for it"
        book.author = new Author()

        then: "the book should also be valid"
        book.validate()
    }

    void "test book persistence"() {
        when: "we try to persist an invalid book"
        Book book = new Book().with {
            it.title = null
            it.dateOfPublishing = null
            it
        }
        then: "we save method should return null"
        !book.save()

        when: "we try to persist a valid book without author"
        book = new Book().with {
            it.title = "The power of habit"
            it
        }
        then: "the book should be persisted"
        book.save()
        Book.findAll().size() == 1
    }
}
