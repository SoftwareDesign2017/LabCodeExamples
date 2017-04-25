package example6

import org.joda.time.DateTime

import java.util.Date

class Author {

    String name
    Date dateOfBirth

    static hasMany = [books: Book]

    static constraints = {
        name(minSize: 5, nullable: false)
        dateOfBirth(nullable: false)
    }
    static mapping = {
        datasources(['mysqlDataSource'])
        books cascade: 'all-delete-orphan'
        books lazy: false
    }
}
