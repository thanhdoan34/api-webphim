package com.project.movie.dao;

import com.project.movie.document.Comment;
import com.project.movie.document.Film;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FilmRepository extends MongoRepository<Film, String> {
    List<Film> findFilmByAgeGreaterThanEqual(int age);
}
