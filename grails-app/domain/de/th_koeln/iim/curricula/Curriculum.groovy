package de.th_koeln.iim.curricula

class Curriculum {

    int year
    String comment

    static hasMany=[modules:Module]
    static belongsTo=[programme:StudyProgramme]

    static constraints = {
      year(nullable:false, blank:false, matches:"[12][0-9]{3}")
    }
}
