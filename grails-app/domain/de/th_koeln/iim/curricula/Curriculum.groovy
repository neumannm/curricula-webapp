package de.th_koeln.iim.curricula

class Curriculum {

    int year
    String comment
    StudyProgramme programme

    static hasMany=[modules:Module]
    static belongsTo=[programme:StudyProgramme]

    static constraints = {
      year(nullable:false, blank:false, min:1980, max:2099)
    }

    String toString(){
        return "${programme}:${year}"
    }

    static mapping = {
        table 'curricula'
    }
}
