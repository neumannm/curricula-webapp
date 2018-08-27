package de.th_koeln.iim.curricula

import grails.gorm.services.Service

@Service(Curriculum)
interface CurriculumService {

    Curriculum get(Serializable id)

    List<Curriculum> list(Map args)

    Long count()

    void delete(Serializable id)

    Curriculum save(Curriculum curriculum)

}