package com.fachrizal

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AnimeController {

    AnimeService animeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond animeService.list(params), model:[animeCount: animeService.count()]
    }

    def show(Long id) {
        respond animeService.get(id)
    }

    def create() {
        respond new Anime(params)
    }

    def save(Anime anime) {
        if (anime == null) {
            notFound()
            return
        }

        try {
            animeService.save(anime)
        } catch (ValidationException e) {
            respond anime.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'anime.label', default: 'Anime'), anime.id])
                redirect anime
            }
            '*' { respond anime, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond animeService.get(id)
    }

    def update(Anime anime) {
        if (anime == null) {
            notFound()
            return
        }

        try {
            animeService.save(anime)
        } catch (ValidationException e) {
            respond anime.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'anime.label', default: 'Anime'), anime.id])
                redirect anime
            }
            '*'{ respond anime, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        animeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'anime.label', default: 'Anime'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'anime.label', default: 'Anime'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
