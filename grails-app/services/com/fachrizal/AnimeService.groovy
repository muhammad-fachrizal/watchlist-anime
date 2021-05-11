package com.fachrizal

import grails.gorm.services.Service

@Service(Anime)
interface AnimeService {

    Anime get(Serializable id)

    List<Anime> list(Map args)

    Long count()

    void delete(Serializable id)

    Anime save(Anime anime)

}