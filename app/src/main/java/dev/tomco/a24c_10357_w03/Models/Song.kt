package dev.tomco.a24c_10357_w03.Models

data class Song private constructor(
    val name: String,
    val artist: String,
    val lengthInSeconds: Int,
    val releaseDate: Long,
    val rating: Float,
    val tags: List<String>
) {
    class Builder(
        var name: String = "",
        var artist: String = "",
        var lengthInSeconds: Int = 0,
        var releaseDate: Long = 0L,
        var rating: Float = 0.0F,
        var tags: List<String> = mutableListOf()
    ) {
        fun name(name: String) = apply { this.name = name }
        fun artist(artist: String) = apply { this.artist = artist }
        fun lengthInSeconds(lengthInSeconds: Int) = apply { this.lengthInSeconds = lengthInSeconds }
        fun releaseDate(releaseDate: Long) = apply { this.releaseDate = releaseDate }
        fun rating(rating: Float) = apply { this.rating = rating }
        fun tags(tags: List<String>) = apply { this.tags = tags }
        fun build() = Song(
            name, artist, lengthInSeconds, releaseDate, rating, tags
        )
    }
}
