package example6

class Book {

    String title
    Date dateOfPublishing

    static belongsTo = [author: Author]

    static constraints = {
        title(nullable: false, minSize: 2)
        dateOfPublishing(nullable: true)
        author(nullable: true, validator: {
            auth, obj -> return obj.dateOfPublishing != null ? obj.author != null : true
        })
    }
    static mapping = {
        author cascade: 'all'
    }

    boolean isPublished() {
        return dateOfPublishing != null
    }

}
