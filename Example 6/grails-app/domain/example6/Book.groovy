package example6

import org.joda.time.DateTime

class Book {

    String title
    DateTime dateOfPublishing

    static belongsTo = [author: Author]

    static constraints = {
        title(nullable: false, minSize: 2)
        dateOfPublishing(nullable: true)
        author(nullable: true, validator: {
            auth, obj -> return obj.dateOfPublishing != null ? obj.author != null : true
        })
    }
    static mapping = {
        datasources(['mysqlDataSource'])
        author cascade: 'all'
    }

    boolean isPublished() {
        return dateOfPublishing != null
    }

}
