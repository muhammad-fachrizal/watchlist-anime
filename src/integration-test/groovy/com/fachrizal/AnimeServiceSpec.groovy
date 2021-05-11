package com.fachrizal

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AnimeServiceSpec extends Specification {

    AnimeService animeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Anime(...).save(flush: true, failOnError: true)
        //new Anime(...).save(flush: true, failOnError: true)
        //Anime anime = new Anime(...).save(flush: true, failOnError: true)
        //new Anime(...).save(flush: true, failOnError: true)
        //new Anime(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //anime.id
    }

    void "test get"() {
        setupData()

        expect:
        animeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Anime> animeList = animeService.list(max: 2, offset: 2)

        then:
        animeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        animeService.count() == 5
    }

    void "test delete"() {
        Long animeId = setupData()

        expect:
        animeService.count() == 5

        when:
        animeService.delete(animeId)
        sessionFactory.currentSession.flush()

        then:
        animeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Anime anime = new Anime()
        animeService.save(anime)

        then:
        anime.id != null
    }
}
