package de.th_koeln.iim.curricula

class University {

    String name
    City city
    String type
    // delete a university if the city item is deleted
    static belongsTo=[city:City]
    static hasMany=[programmes:StudyProgramme]

    //TODO: Currently the size constraint cannot be used in addition to blank or nullable. Use a custom validator for these combinations. 
    static constraints = {
      name(nullable:false, blank:false, matches:"[a-zA-Z\\-äöüÄÖÜß ]+")
      type inList: ["Uni", "HAW", "Other"]
      city()
    }

    String toString(){
        return "${name}, ${city}"
    }

    static mapping = {
        table 'universities'
    }
}
