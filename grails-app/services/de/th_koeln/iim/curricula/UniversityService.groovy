package de.th_koeln.iim.curricula

import grails.gorm.services.Service

@Service(University)
interface UniversityService {

    University get(Serializable id)

    List<University> list(Map args)

    Long count()

    void delete(Serializable id)

    University save(University university)

}