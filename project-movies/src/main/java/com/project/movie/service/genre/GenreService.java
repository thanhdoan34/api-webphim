package com.project.movie.service.genre;

import com.project.movie.document.Genre;
import com.project.movie.document.User;

import java.util.List;

public interface GenreService {
    List<Genre> findAll();

    Genre findById(String id);

    boolean insertGenre(Genre user);

    boolean updateGenre(Genre user);

    void delGenre(String id);
}
