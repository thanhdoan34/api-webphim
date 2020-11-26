package com.project.movie.service.film;

import com.project.movie.document.Film;

import java.util.List;

public interface FilmService {
    List<Film> findAll();

    Boolean insertFilm(Film film);

    Boolean updateFilm(Film film);

    void delFilm(String id);

    Film findFilmById(String id);

    List<Film> findFimlByAge(int age);
}
