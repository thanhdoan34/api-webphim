package com.project.movie.controller;

import com.project.movie.document.Director;
import com.project.movie.service.director.DirectorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Log4j2
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping(value = "/directors")
    public ResponseEntity<?> findAllDirector() {
        List<Director> directorList = this.directorService.findAll();
        return directorList != null ? new ResponseEntity<>(directorList, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/director/{id}", produces = "application/json")
    public ResponseEntity<Director> findDirectorById(@PathVariable(value = "id", required = true) String id) {
        Director director = this.directorService.findById(id);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @PostMapping(value = "/director", produces = "application/json")
    public ResponseEntity<?> insertDirector(@RequestBody(required = false) Director director) {
        return this.directorService.insertDirector(director) ? new ResponseEntity<>(true, HttpStatus.CREATED) :
                new ResponseEntity<>(false, HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/director", produces = "application/json")
    public ResponseEntity<?> updateFilm(@RequestBody Director director) {
        return this.directorService.updateDirector(director) ? new ResponseEntity<>(true, HttpStatus.ACCEPTED) :
                new ResponseEntity<>(false, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/director/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFilm(@PathVariable(value = "id") String id) {
        this.directorService.delDirector(id);

    }
}
