package example6

class Author {

    String name
    Date dateOfBirth

    static hasMany = [books: Book]

    static constraints = {
        name(minSize: 5, nullable: false)
        dateOfBirth(nullable: false)
    }
    static mapping = {
        books cascade: 'all-delete-orphan'
        books lazy: false
    }

    @Override
    String toString() {
        return id + " : " + name
    }
}
