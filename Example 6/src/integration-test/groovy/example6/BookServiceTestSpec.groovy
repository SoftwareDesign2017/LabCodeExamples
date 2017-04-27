package example6

import grails.test.mixin.integration.Integration
import spock.lang.Specification

@Integration
class BookServiceTestSpec extends Specification {

    def bookService

    void "changeAuthor"() {
        given: "two authors and a book"

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
            it.dateOfPublishing = new Date()
            it
        }.save()

        when: "I change the author"
        bookService.changeAuthor(book, author2.id)

        then: "The book should have a different author"
        Book.findById(book.id).author == author2
    }
}
