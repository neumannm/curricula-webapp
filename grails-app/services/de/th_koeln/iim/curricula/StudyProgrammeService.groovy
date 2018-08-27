package de.th_koeln.iim.curricula

import grails.gorm.services.Service

@Service(StudyProgramme)
interface StudyProgrammeService {

    StudyProgramme get(Serializable id)

    List<StudyProgramme> list(Map args)

    Long count()

    void delete(Serializable id)

    StudyProgramme save(StudyProgramme studyProgramme)

}