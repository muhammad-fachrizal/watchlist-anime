package com.fachrizal

class Anime {
    static belongsTo = [studio: Studio]
    String name
    Integer episodes
    String genres
    String aired

    static constraints = {
        name size: 5..40, blank: false
        episodes min: 1
        genres size: 5..40, blank: false
        aired size: 5..40, blank: false
    }

    String toString() {
        name
    }
}
