package de.th_koeln.iim.curricula

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class StudyProgrammeController {

    StudyProgrammeService studyProgrammeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond studyProgrammeService.list(params), model:[studyProgrammeCount: studyProgrammeService.count()]
    }

    def show(Long id) {
        respond studyProgrammeService.get(id)
    }

    def create() {
        respond new StudyProgramme(params)
    }

    def save(StudyProgramme studyProgramme) {
        if (studyProgramme == null) {
            notFound()
            return
        }

        try {
            studyProgrammeService.save(studyProgramme)
        } catch (ValidationException e) {
            respond studyProgramme.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'studyProgramme.label', default: 'StudyProgramme'), studyProgramme.id])
                redirect studyProgramme
            }
            '*' { respond studyProgramme, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond studyProgrammeService.get(id)
    }

    def update(StudyProgramme studyProgramme) {
        if (studyProgramme == null) {
            notFound()
            return
        }

        try {
            studyProgrammeService.save(studyProgramme)
        } catch (ValidationException e) {
            respond studyProgramme.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'studyProgramme.label', default: 'StudyProgramme'), studyProgramme.id])
                redirect studyProgramme
            }
            '*'{ respond studyProgramme, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        studyProgrammeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'studyProgramme.label', default: 'StudyProgramme'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'studyProgramme.label', default: 'StudyProgramme'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
