package example6

import org.joda.time.DateTime

class Author {

    String name
    DateTime dateOfBirth

    static hasMany = [books: Book]

    static constraints = {
        name(minSize: 5, nullable: false)
        dateOfBirth(nullable: false)
    }
    static mapping = {
        datasources(['inMemoryDb','mysqlDataSource'])
        books cascade: 'all-delete-orphan'
    }
}
