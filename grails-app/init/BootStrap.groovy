import vaquita.User
class BootStrap {

    def init = { servletContext ->
        new User (mail: "borafael@gmail.com", pass: "1234").save()
        new User (mail: "nicolascoco85@gmail.com", pass: "1234").save()
        new User (mail: "cosso@gmail.com", pass: "1234").save()
        new User (mail: "simon@gmail.com", pass: "1234").save()
        new User (mail: "pepeluis@gmail.com", pass: "1234").save()
    }

    def destroy = {
    }
}
