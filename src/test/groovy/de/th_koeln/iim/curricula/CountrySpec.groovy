package de.th_koeln.iim.curricula

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Ignore;

import grails.test.hibernate.HibernateSpec

class CountrySpec extends Specification implements DomainUnitTest<Country> {

    List<Class> getDomainClasses() { [Country] }

    def setup() {
    }

    def cleanup() {
    }

    def "country's name unique constraint"() {

        when: 'You instantiate a country with name which has been never used before'
        def country1 = new Country(name: 'Azerbaidschan')

        then: 'country is valid instance'
        country1.validate()

        and: 'we can save it, and we get back a not null GORM Entity'
        country1.save()

        and: 'there is one additional Country'
        Country.count() == old(Country.count()) + 1

        when: 'instanting a different country with the same name'
        def country2 = new Country(name: 'Azerbaidschan')

        then: 'the country instance is not valid'
        !country2.validate(['name'])

        and: 'unique error code is populated'
        country2.errors['name']?.code == 'unique'

        and: 'trying to save fails too'
        !country2.save()

        and: 'no country has been added'
        Country.count() == old(Country.count())
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
        String str = 'Uzürkistan-Ungarn'
        domain.name = str

        then:
        domain.validate(['name'])

        when: 'for an invalid string'
        str = 'Sri Lanka 123'
        domain.name = str

        then:
        !domain.validate(['name'])
        domain.errors['name'].code == 'matches.invalid'
    }

    @Ignore
    void 'test name can have a minimum of 2 and maximum of 50 characters'() {
        when: 'for a string of 51 characters'
        String str = 'a' * 51
        domain.name = str

        then: 'name validation fails'
        !domain.validate(['name'])
        domain.errors['name'].code == 'maxSize.exceeded'

        when: 'for a string of 1 character'
        str = 'a'
        domain.name = str

        then: 'name validation fails'
        !domain.validate(['name'])
        domain.errors['name'].code == 'minSize.notmet'

        when: 'for a string of 50 characters'
        str = 'a' * 50
        domain.name = str

        then: 'name validation passes'
        domain.validate(['name'])
    }
}
