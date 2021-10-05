package com.ish.animeapi.datasource

import com.ish.animeapi.utility.Anime

interface AnimeDataSource {
    fun getAnime(): Collection<Anime>
}