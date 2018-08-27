package de.th_koeln.iim.curricula

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class StudyProgrammeServiceSpec extends Specification {

    StudyProgrammeService studyProgrammeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new StudyProgramme(...).save(flush: true, failOnError: true)
        //new StudyProgramme(...).save(flush: true, failOnError: true)
        //StudyProgramme studyProgramme = new StudyProgramme(...).save(flush: true, failOnError: true)
        //new StudyProgramme(...).save(flush: true, failOnError: true)
        //new StudyProgramme(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //studyProgramme.id
    }

    void "test get"() {
        setupData()

        expect:
        studyProgrammeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<StudyProgramme> studyProgrammeList = studyProgrammeService.list(max: 2, offset: 2)

        then:
        studyProgrammeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        studyProgrammeService.count() == 5
    }

    void "test delete"() {
        Long studyProgrammeId = setupData()

        expect:
        studyProgrammeService.count() == 5

        when:
        studyProgrammeService.delete(studyProgrammeId)
        sessionFactory.currentSession.flush()

        then:
        studyProgrammeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        StudyProgramme studyProgramme = new StudyProgramme()
        studyProgrammeService.save(studyProgramme)

        then:
        studyProgramme.id != null
    }
}
