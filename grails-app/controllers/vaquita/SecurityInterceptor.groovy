package vaquita


class SecurityInterceptor {

    public SecurityInterceptor() {

                matchAll()
                    .excludes(uri: '/')
                    .excludes(controller: 'security', method: 'login')
            }

            boolean before() {

                if(session.user == null) {

                    redirect(uri: '/')
                    return false
                }

                return true
            }

            boolean after() { true }

            void afterView() {
                // no-op
            }
        }
