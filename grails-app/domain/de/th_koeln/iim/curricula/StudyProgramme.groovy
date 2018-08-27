package de.th_koeln.iim.curricula

class StudyProgramme {

    String name
    String degree

    static hasMany=[curricula:Curriculum]
    static belongsTo=[university:University]

    static constraints = {
      name(nullable:false, blank:false, size:5..100)
    }
}
