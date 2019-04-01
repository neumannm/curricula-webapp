package de.th_koeln.iim.curricula

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Ignore

class ModuleSpec extends Specification implements DomainUnitTest<Module> {

    def setup() {
    }

    def cleanup() {
    }

    void 'test title cannot be null'() {
        when:
        domain.title = null

        then:
        !domain.validate(['title'])
        domain.errors['title'].code == 'nullable'
    }

    void 'test title cannot be blank'() {
        when:
        domain.title = ''

        then:
        !domain.validate(['title'])
    }

    void 'test description cannot be null'() {
        when:
        domain.description = null

        then:
        !domain.validate(['description'])
        domain.errors['description'].code == 'nullable'
    }

    void 'test description cannot be blank'() {
        when:
        domain.description = ''

        then:
        !domain.validate(['description'])
    }

    void 'test semester must be minimum 1'() {
        when:
        domain.semester = 1

        then:
        domain.validate(['semester'])

        when:
        domain.semester = 0

        then:
        !domain.validate(['semester'])
        domain.errors['semester'].code == 'min.notmet'
    }

    @Ignore //since scale does not register validation errors
    void 'test ects cannot have more than 2 decimal places'() {
        when:
        Float num = 2F
        domain.ects = num

        then:
        domain.validate(['ects'])

        when:
        num = 2.5
        domain.ects = num

        then:
        domain.validate(['ects'])

        when:
        num = 2.55
        domain.ects = num

        then:
        domain.validate(['ects'])

        when:
        num = 2.555
        domain.ects = num

        then:
        !domain.validate(['ects'])
    }
}
