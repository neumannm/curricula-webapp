package de.th_koeln.iim.curricula

class University {

    String name
    City city;
    // delete a university if the city item is deleted
    static belongsTo=[city:City]

    static constraints = {
      name(nullable:false, blank:false, size:4..80, matches:"[a-zA-Z\\-äöüÄÖÜß ]+")
      city()
    }

    String toString(){
        return "${name}, ${city}"
    }
}
