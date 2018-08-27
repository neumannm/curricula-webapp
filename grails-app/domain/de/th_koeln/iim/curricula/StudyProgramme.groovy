package de.th_koeln.iim.curricula

class StudyProgramme {

    String name
    String degree
    University university

    static hasMany=[curricula:Curriculum]
    static belongsTo=[university:University]

    static constraints = {
      name(nullable:false, blank:false, size:5..100)
      university()
    }

    String toString(){
        return "${name}(${degree}), ${university}"
    }
}
