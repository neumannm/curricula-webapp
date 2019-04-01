package de.th_koeln.iim.curricula

class City {

    String name

    static hasMany=[universities:University]
    // delete a city if the country item is deleted
    static belongsTo=[country:Country]

    //TODO: Currently the size constraint cannot be used in addition to blank or nullable. Use a custom validator for these combinations.
    static constraints = {
      name(nullable:false, blank:false, matches:"[a-zA-Z\\-äöüÄÖÜß ]+")
      country()
      universities()
    }

    String toString(){
        return name
    }

    static mapping = {
        table 'cities'
    }
}
