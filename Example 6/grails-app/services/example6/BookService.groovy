package example6

import grails.transaction.Transactional

@Transactional
class BookService {

    def authorService

    def changeAuthor(Book book, Long newAuthorId) {
        def newAuthor = authorService.findById(newAuthorId)
        if (newAuthor) {
            def previousAuthor = book.author
            previousAuthor.removeFromBooks(book)
            previousAuthor.save()
            book.author = newAuthor
            book.save()
            newAuthor.addToBooks(book)
            newAuthor.save()
        }
    }

    def publishBook(Book book, Date dateOfPublishing, Author author) {
        book.dateOfPublishing = dateOfPublishing
        book.author = author
        book.save()
        author.addToBooks(book)
        author.save()
    }
}
