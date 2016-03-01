import vaquita.User
class BootStrap {

    def init = { servletContext ->
      new User (mail: "a", pass: "1234").save()
      new User (mail: "b", pass: "1234").save()
    }
    def destroy = {
    }
}
