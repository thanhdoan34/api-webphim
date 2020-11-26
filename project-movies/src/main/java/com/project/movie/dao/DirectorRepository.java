package com.project.movie.dao;

import com.project.movie.document.Director;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DirectorRepository extends MongoRepository<Director, String> {
    Director findBy_id(String id);
}
