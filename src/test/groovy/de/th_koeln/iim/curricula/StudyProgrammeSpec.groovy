package de.th_koeln.iim.curricula

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class StudyProgrammeSpec extends Specification implements DomainUnitTest<StudyProgramme> {

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

    @Unroll('StudyProgramme.validate() with keyAspect: #value should have returned #expected with errorCode: #expectedErrorCode')
    void 'test keyAspect validation'() {
        when:
        domain.keyAspect = value

        then:
        expected == domain.validate(['keyAspect'])
        domain.errors['keyAspect']?.code == expectedErrorCode

        where:
        value                               | expected  | expectedErrorCode
        "Library Science"                   | true      | null
        "Information Science"               | true      | null
        "Library and Information Science"   | true      | null
        "Data Science"                      | true      | null
        "foobar"                            | false     | 'not.inList'
    }

}
