package de.th_koeln.iim.curricula

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Ignore;

class UniversitySpec extends Specification implements DomainUnitTest<University> {

    def setup() {
    }

    def cleanup() {
    }

    void 'test name cannot be null'() {
        when:
        domain.name = null

        then:
        !domain.validate(['name'])
        domain.errors['name'].code == 'nullable'
    }

    void 'test name cannot be blank'() {
        when:
        domain.name = ''

        then:
        !domain.validate(['name'])
    }

    void 'test name has to contain valid chars'(){
        when: 'for a valid string'
        String str = 'Uni Bambürg-Singelfingen'
        domain.name = str

        then:
        domain.validate(['name'])

        when: 'for an invalid string'
        str = 'Fachhochschule Häus97leberg'
        domain.name = str

        then:
        !domain.validate(['name'])
        domain.errors['name'].code == 'matches.invalid'
    }

    @Ignore
    void 'test name can have a minimum of 4 and maximum of 80 characters'() {
        when: 'for a string of 81 characters'
        String str = 'a' * 81
        domain.name = str

        then: 'name validation fails'
        !domain.validate(['name'])
        domain.errors['name'].code == 'maxSize.exceeded'

        when: 'for a string of 3 characters'
        str = 'a' * 3
        domain.name = str

        then: 'name validation fails'
        !domain.validate(['name'])
        domain.errors['name'].code == 'minSize.notmet'

        when: 'for a string of 80 characters'
        str = 'a' * 80
        domain.name = str

        then: 'name validation passes'
        domain.validate(['name'])
    }
}
