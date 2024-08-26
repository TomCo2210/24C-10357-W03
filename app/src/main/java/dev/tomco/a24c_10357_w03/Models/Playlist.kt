package dev.tomco.a24c_10357_w03.Models

data class Playlist private constructor(
    val name: String,
    val allSongs: List<Song>
) {
    class Builder(
        var name: String = "",
        var allSongs: List<Song> = mutableListOf()
    ) {
        fun name(name: String) = apply { this.name = name }
        fun addSong(song: Song) = apply { (this.allSongs as MutableList).add(song) }
        fun build() = Playlist(name, allSongs)
    }
}