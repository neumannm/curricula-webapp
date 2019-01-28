package de.th_koeln.iim.curricula

class StudyProgramme {

    String name
    String degree
    String keyAspect
    University university

    static hasMany=[curricula:Curriculum]
    static belongsTo=[university:University]

    static constraints = {
      name(nullable:false, blank:false, size:5..100)
      keyAspect inList: ["Library Science", "Information Science", "Library and Information Science", "Data Science"]
      university()
    }

    String toString(){
        return "${name} (${degree}), ${university}"
    }

    static mapping = {
        table 'programmes'
    }
}
