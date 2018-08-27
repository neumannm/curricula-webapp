package de.th_koeln.iim.curricula

class City {

    String name

    static hasMany=[universities:University]
    // delete a city if the country item is deleted
    static belongsTo=[country:Country]

    static constraints = {
      name(nullable:false, blank:false, size:2..50, matches:"[a-zA-Z\\-äöüÄÖÜß ]+")
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
