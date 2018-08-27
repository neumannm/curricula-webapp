package de.th_koeln.iim.curricula

class Country {

    String name

    static hasMany=[cities:City]

    static constraints = {
      name(nullable:false, blank:false, size:2..50, matches:"[a-zA-Z\\-äöüÄÖÜß]+")
    }

    String toString(){
        return name
    }
}
