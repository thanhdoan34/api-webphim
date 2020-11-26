package com.project.movie.service.film;

import com.project.movie.dao.FilmRepository;
import com.project.movie.document.Film;
import com.project.movie.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImp implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Boolean insertFilm(Film film) {
        return (filmRepository.save(film) instanceof Film);
    }

    @Override
    public Boolean updateFilm(Film film) {
        Film film1 = filmRepository.findById(film.getId()).orElseThrow(ResourceNotFoundException::new);
        film1.setActor(film.getActor());
        film1.setAge(film.getAge());
        film1.setContent(film.getContent());
        film1.setCreateAt(film.getCreateAt());
        film1.setDirector(film.getDirector());
        film1.setEsposide(film.getEsposide());
        film1.setLanguage(film.getLanguage());
        film1.setModifyAt(film.getModifyAt());
        film1.setName(film.getName());
        film1.setNation(film.getNation());
        film1.setQuality(film.getQuality());
        film1.setRelease(film.getRelease());
        film1.setStatus(film.getStatus());
        film1.setSeries_movie(film.getSeries_movie());
        film1.setTime(film.getTime());
        film1.setGenre(film.getGenre());
        film1.setTypes(film.getTypes());
        film1.setUrl(film.getUrl());
        film1.setStatusActive(film.getStatusActive());
        film1.setComment(film.getComment());
        return filmRepository.save(film1) instanceof Film;
    }

    @Override
    public void delFilm(String id) {
        Film film1 = filmRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        filmRepository.deleteById(id);
    }

    @Override
    public Film findFilmById(String id) {
        Film film1 = filmRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return film1;
    }

    @Override
    public List<Film> findFimlByAge(int age) {
        return filmRepository.findFilmByAgeGreaterThanEqual(age);
    }
}
