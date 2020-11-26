package com.project.movie.service.director;

import com.project.movie.document.Director;
import com.project.movie.document.Film;

import java.util.List;

public interface DirectorService {
    List<Director> findAll();

    Director findById(String id);

    Boolean insertDirector(Director director);

    Boolean updateDirector(Director director);

    void delDirector(String id);
}
