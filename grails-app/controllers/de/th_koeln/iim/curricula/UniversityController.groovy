package de.th_koeln.iim.curricula

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class UniversityController {

    UniversityService universityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond universityService.list(params), model:[universityCount: universityService.count()]
    }

    def show(Long id) {
        respond universityService.get(id)
    }

    def create() {
        respond new University(params)
    }

    def save(University university) {
        if (university == null) {
            notFound()
            return
        }

        try {
            universityService.save(university)
        } catch (ValidationException e) {
            respond university.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'university.label', default: 'University'), university.id])
                redirect university
            }
            '*' { respond university, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond universityService.get(id)
    }

    def update(University university) {
        if (university == null) {
            notFound()
            return
        }

        try {
            universityService.save(university)
        } catch (ValidationException e) {
            respond university.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'university.label', default: 'University'), university.id])
                redirect university
            }
            '*'{ respond university, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        universityService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'university.label', default: 'University'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'university.label', default: 'University'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
