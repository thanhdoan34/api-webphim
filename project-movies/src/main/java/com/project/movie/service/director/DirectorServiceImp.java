package com.project.movie.service.director;

import com.project.movie.dao.DirectorRepository;
import com.project.movie.document.Director;
import com.project.movie.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DirectorServiceImp implements DirectorService {

    final private DirectorRepository directorRepository;

    public DirectorServiceImp(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public List<Director> findAll() {
        return this.directorRepository.findAll();
    }

    @Override
    public Director findById(String id) {
        return this.directorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Boolean insertDirector(Director director) {
        if (director.getCreateAt() == null)
            director.setCreateAt(LocalDateTime.now());
        return this.directorRepository.save(director) instanceof Director;
    }

    @Override
    public Boolean updateDirector(Director director) {
        Director director1 = this.findById(director.get_id());
        director1.set_id(director.get_id());
        director1.setImage(director.getImage());
        director1.setName(director.getName());
        director1.setModifyAt(LocalDateTime.now());
        director1.setCreateAt(director.getCreateAt());
        return directorRepository.save(director1) instanceof Director;
    }

    @Override
    public void delDirector(String id) {
        Director director = this.findById(id);
        this.directorRepository.deleteById(director.get_id());
    }
}
