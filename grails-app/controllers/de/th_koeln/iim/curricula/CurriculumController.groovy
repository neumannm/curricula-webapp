package de.th_koeln.iim.curricula

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CurriculumController {

    CurriculumService curriculumService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond curriculumService.list(params), model:[curriculumCount: curriculumService.count()]
    }

    def show(Long id) {
        respond curriculumService.get(id)
    }

    def create() {
        respond new Curriculum(params)
    }

    def save(Curriculum curriculum) {
        if (curriculum == null) {
            notFound()
            return
        }

        try {
            curriculumService.save(curriculum)
        } catch (ValidationException e) {
            respond curriculum.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'curriculum.label', default: 'Curriculum'), curriculum.id])
                redirect curriculum
            }
            '*' { respond curriculum, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond curriculumService.get(id)
    }

    def update(Curriculum curriculum) {
        if (curriculum == null) {
            notFound()
            return
        }

        try {
            curriculumService.save(curriculum)
        } catch (ValidationException e) {
            respond curriculum.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'curriculum.label', default: 'Curriculum'), curriculum.id])
                redirect curriculum
            }
            '*'{ respond curriculum, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        curriculumService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'curriculum.label', default: 'Curriculum'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'curriculum.label', default: 'Curriculum'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
