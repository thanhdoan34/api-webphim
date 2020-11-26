package com.project.movie.service.genre;

import com.project.movie.dao.GenreRepository;
import com.project.movie.document.Film;
import com.project.movie.document.Genre;
import com.project.movie.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImp implements GenreService {


    final GenreRepository genreRepository;

    public GenreServiceImp(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(String id) {
        return genreRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean insertGenre(Genre user) {
        return genreRepository.save(user) instanceof Genre;
    }

    @Override
    public boolean updateGenre(Genre user) {
        Genre genre = findById(user.get_id());
        genre.set_id(user.get_id());
        genre.setName(user.getName());
        genre.setModifyAt(user.getModifyAt());
        return genreRepository.save(genre) instanceof Genre;
    }

    @Override
    public void delGenre(String id) {
        Genre genre = genreRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        genreRepository.deleteById(id);
    }
}
