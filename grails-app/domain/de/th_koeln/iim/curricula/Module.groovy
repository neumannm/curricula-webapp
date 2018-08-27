package de.th_koeln.iim.curricula

class Module {

    String title
    int semester
    String description
    String content
    String teachingMethod
    String ects
    boolean isMandatory

    static belongsTo=[curriculum:Curriculum]

    static constraints = {
      title(nullable:false, blank:false)
      description(nullable:false, blank:false, size: 1..15000, widget:'textarea')
      content(nullable:true, blank:true, size: 0..20000, widget:'textarea')
      ects(nullable:true, blank:true)
      teachingMethod(nullable:true, blank:true)
      semester(min:1)
      isMandatory()
      curriculum()
    }

    static mapping = {
       table 'modules'
       description sqlType: 'text'
       content sqlType: 'text'
    }

    String toString(){
        return title
    }
}
