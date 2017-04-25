package example6

class BootStrap {

    def init = { servletContext ->
        println 'starting up application'
    }
    def destroy = {
    }
}
