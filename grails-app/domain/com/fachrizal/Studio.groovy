package com.fachrizal

class Studio {
    String name
    String headquarters
    String founded
    String logo
    String website
    static hasMany = [anime: Anime]

    static constraints = {
        name size: 4..40, blank: false, unique: true
        headquarters size: 5..30, blank: false
        founded size: 5..30, blank: false
        logo size: 5..255, blank: false
        website size: 5..30, blank: false
    }

    String toString() {
        name
    }
}
