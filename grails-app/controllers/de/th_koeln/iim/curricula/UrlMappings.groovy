package de.th_koeln.iim.curricula

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //mapping to a view
        "/"(view:"/index") //grails-app/views/index.gsp
        "500"(view:'/error') //grails-app/views/error.gsp
        "404"(view:'/notFound') //grails-app/views/notFound.gsp

        //mapping to a controller
        "/login/$action?"(controller: "login")
        "/logout/$action?" {
            controller = 'logout'
            action = [POST: 'index']
        }
    }
}
