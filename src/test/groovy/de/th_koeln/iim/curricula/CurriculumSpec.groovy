package de.th_koeln.iim.curricula

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

import spock.lang.Unroll

class CurriculumSpec extends Specification implements DomainUnitTest<Curriculum> {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll('Curriculum.validate() with year: #value should have returned #expected with errorCode: #expectedErrorCode')
    void 'test year validation'() {
        when:
        domain.year = value

        then:
        expected == domain.validate(['year'])
        domain.errors['year']?.code == expectedErrorCode

        where:
        value                  | expected  | expectedErrorCode
        1979                   | false     | 'min.notmet'
        2100                   | false     | 'max.exceeded'
        1981                   | true      | null
    }
}
