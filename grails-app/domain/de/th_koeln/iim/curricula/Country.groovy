package de.th_koeln.iim.curricula

class Country {

    String name

    static hasMany=[cities:City]

    //TODO: Currently the size constraint cannot be used in addition to blank or nullable. Use a custom validator for these combinations.
    static constraints = {
      name(nullable:false, blank:false, matches:"[a-zA-Z\\-äöüÄÖÜß ]+", unique:true)
    }

    String toString(){
        return name
    }

    static mapping = {
        table 'countries'
    }
}
