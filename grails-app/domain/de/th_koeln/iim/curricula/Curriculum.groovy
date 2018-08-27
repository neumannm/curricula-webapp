package de.th_koeln.iim.curricula

class Curriculum {

    int year
    String comment
    StudyProgramme programme

    static hasMany=[modules:Module]
    static belongsTo=[programme:StudyProgramme]

    //TODO: correct constraint for year
    static constraints = {
      year(nullable:false, blank:false)
    }

    String toString(){
        return "${programme}:${year}"
    }

    static mapping = {
        table 'curricula'
    }
}