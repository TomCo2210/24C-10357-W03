package dev.tomco.a24c_10357_w03.Utilities

import dev.tomco.a24c_10357_w03.Models.Playlist
import dev.tomco.a24c_10357_w03.Models.Song
import java.time.LocalDate
import java.util.Arrays

object DataManager {
    fun generatePlaylist(): Playlist {
        return Playlist
            .Builder()
            .name("Top Two!")
            .addSong(
                Song
                    .Builder()
                    .name("Swimming Pools")
                    .artist("Kendrick Lamar")
                    .lengthInSeconds(231)
                    .releaseDate(LocalDate.of(2013, 8, 3).toEpochDay())
                    .rating(4.3F)
                    .tags(Arrays.asList(*arrayOf("Rap", "HipHop")))
                    .build()
            )
            .addSong(
                Song
                    .Builder()
                    .name("עטור מצחך")
                    .artist("אריק אינשטיין")
                    .lengthInSeconds(252)
                    .releaseDate(LocalDate.of(1977, 1, 1).toEpochDay())
                    .rating(4.8F)
                    .tags(Arrays.asList(*arrayOf("עברית", "Hebrew")))
                    .build()
            ).build()
    }
}