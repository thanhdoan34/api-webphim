package com.project.movie.controller;

import com.project.movie.document.Genre;
import com.project.movie.service.genre.GenreService;
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
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping(value = "/genres")
    public ResponseEntity<?> findAllGenre() {
        List<Genre> genreList = genreService.findAll();
        return genreList != null ? new ResponseEntity<>(genreList, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/genre/{id}", produces = "application/json")
    public ResponseEntity<Genre> findGenreById(@PathVariable(value = "id", required = true) String id) {
        log.info("findGenreById info");
        Genre genre = genreService.findById(id);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }


    @PostMapping(value = "/genre", produces = "application/json")
    public ResponseEntity<?> insertGenre(@RequestBody(required = true) @Validated Genre genre) {
        return this.genreService.insertGenre(genre) ? new ResponseEntity<>(true, HttpStatus.CREATED) :
                new ResponseEntity<>(false, HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/genre", produces = "application/json")
    public ResponseEntity<?> updateGenre(@RequestBody @Validated Genre genre) {
        log.info("updateGenre information");
        return this.genreService.updateGenre(genre) ? new ResponseEntity<>(true, HttpStatus.OK) :
                new ResponseEntity<>(false, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/genre/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGenre(@PathVariable(value = "id") String id) {
        log.info("deleteGenre infor");
        this.genreService.delGenre(id);
    }
}
