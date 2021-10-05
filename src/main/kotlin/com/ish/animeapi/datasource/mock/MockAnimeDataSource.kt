package com.ish.animeapi.datasource.mock

import com.ish.animeapi.datasource.AnimeDataSource
import com.ish.animeapi.utility.Anime
import org.springframework.stereotype.Repository

@Repository
class MockAnimeDataSource : AnimeDataSource {
    override fun getAnime(): Collection<Anime> {
        return listOf(
            Anime(1, "redo", "Ecchi", 4.5),
            Anime(2, "ish", "Meccha", 5.0),
            Anime(3, "yums", "food", 3.1)
        )
    }
}