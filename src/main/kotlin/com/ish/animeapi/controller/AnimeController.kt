package com.ish.animeapi.controller

import com.ish.animeapi.utility.Anime
import com.ish.animeapi.utility.Message
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/anime")
class AnimeController {
    val animeDatabase = mutableListOf<Anime>()

    @PostMapping
    fun addAnime(@RequestBody getAnime: Anime): ResponseEntity<String> {

        animeDatabase.add(getAnime)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("Created Successfully")
    }

    @GetMapping
    fun getAllAnime(): ResponseEntity<MutableList<Anime>>{

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(animeDatabase)
    }

    @GetMapping("/{animeID}")
    fun getIDAnime(@PathVariable animeID: Int): ResponseEntity<Anime>{
        val getAnime : Anime? = animeDatabase.find { it.id == animeID }
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(getAnime)
    }

//    @GetMapping("/{animeName}")
//    fun getNameAnime(@PathVariable animeName: String): ResponseEntity<MutableList<Anime>> {
//        val getAnimes = mutableListOf<Anime>()
//        getAnimes.add(animeDatabase.find { it.name == animeName }!!)
//        return ResponseEntity
//            .status(HttpStatus.OK)
//            .body(getAnimes)
//    }

    @PutMapping("/{animeID}")
    fun updateAnime(@PathVariable animeID: Int, @RequestBody newAnime: Anime):ResponseEntity<Anime> {
        val existingAnime: Anime? = animeDatabase.find { it.id == animeID }
        existingAnime!!.category = newAnime.category
        existingAnime.name = newAnime.name
        existingAnime.rating = newAnime.rating

        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(existingAnime)

    }
}