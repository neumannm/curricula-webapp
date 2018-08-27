package de.th_koeln.iim.curricula

class Curriculum {

    int year
    String comment

    static hasMany=[modules:Module]
    static belongsTo=[programme:StudyProgramme]

    //TODO: correct constraint for year
    static constraints = {
      year(nullable:false, blank:false)
    }
}
