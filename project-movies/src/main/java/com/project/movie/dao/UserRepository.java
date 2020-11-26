package com.project.movie.dao;

import com.project.movie.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsUserByUserName(String username);

    boolean existsUserByEmail(String email);

    User findByUserName(String username);

    User findByUserNameAndPassword(String username, String pw);
}
