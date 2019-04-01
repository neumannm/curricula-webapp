package de.th_koeln.iim.curricula

class StudyProgramme {

    String name
    String degree
    String keyAspect
    University university
    String summary

    static hasMany=[curricula:Curriculum]
    static belongsTo=[university:University]

    //TODO: Currently the size constraint cannot be used in addition to blank or nullable. Use a custom validator for these combinations.
    static constraints = {
      name(nullable:false, blank:false)
      keyAspect inList: ["Library Science", "Information Science", "Library and Information Science", "Data Science"]
      university()
      summary(nullable:true, blank:true, widget:'textarea')
    }

    String toString(){
        return "${name} (${degree}), ${university}"
    }

    static mapping = {
        table 'programmes'
    }
}
