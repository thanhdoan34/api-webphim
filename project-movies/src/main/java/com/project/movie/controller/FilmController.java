package com.project.movie.controller;

import com.project.movie.document.Film;
import com.project.movie.service.film.FilmServiceImp;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Log4j2
public class FilmController {

    @Autowired
    private FilmServiceImp filmServiceImp;

    @GetMapping(value = "/films")
    public ResponseEntity<?> findAllFilm() {
        List<Film> filmList = filmServiceImp.findAll();
        return filmList != null ? new ResponseEntity<>(filmList, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/film/{id}", produces = "application/json")
    public ResponseEntity<Film> findFilmById(@PathVariable(value = "id", required = true) String id) {
        log.info("findFilmById info");
        Film film = filmServiceImp.findFilmById(id);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

    @GetMapping(value = "/films/{age}", produces = "application/json")
    public ResponseEntity<?> findFilmByAge(@PathVariable(value = "age", required = true) int age) {
        log.info("findFilmByAge info");
        List<Film> films = filmServiceImp.findFimlByAge(age);
        return films != null ? new ResponseEntity<>(films, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/film", produces = "application/json")
    public ResponseEntity<?> insertFilm(@RequestBody(required = true) @Validated Film film) {
        return this.filmServiceImp.insertFilm(film) ? new ResponseEntity<>(true, HttpStatus.CREATED) :
                new ResponseEntity<>(false, HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/film", produces = "application/json")
    public ResponseEntity<?> updateFilm(@RequestBody Film film) {
        log.info("updateFilm information");
        return this.filmServiceImp.updateFilm(film) ? new ResponseEntity<>(true, HttpStatus.ACCEPTED) :
                new ResponseEntity<>(false, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/film/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFilm(@PathVariable(value = "id") String id) {
        log.info("deleteFilm infor");
        this.filmServiceImp.delFilm(id);

    }
}
