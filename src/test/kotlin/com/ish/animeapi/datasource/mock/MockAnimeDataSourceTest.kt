package com.ish.animeapi.datasource.mock

import com.ish.animeapi.utility.Anime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockAnimeDataSourceTest {
    private val mockDataSource = MockAnimeDataSource()
    @Test
    fun `should provide a collection of animes`(){
        //given

        //when
        val animes = mockDataSource.getAnime()

        //then
        assertThat(animes).isNotEmpty
    }

    @Test
    fun `Should provide some mock data`(){
        val animes = mockDataSource.getAnime()
        assertThat(animes).allMatch { it.name.isNotBlank() }
    }
}