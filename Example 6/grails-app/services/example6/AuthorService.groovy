package example6

import grails.transaction.Transactional

@Transactional
class AuthorService {

    def findById(Long id) {
        Author.findById(id)
    }

}
