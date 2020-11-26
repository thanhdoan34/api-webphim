package com.project.movie.service.user;

import com.project.movie.document.User;
import com.project.movie.payload.request.LoginRequest;

import java.util.List;

public interface UserService {
    List<User> findAll();

    boolean insertUser(User user);

    boolean updateUser(User user);

    void delUser(String id);

    User findUserById(String id);

    boolean existsUserByUserName(String username);

    boolean existsUserByEmail(String email);

    User loadUserByUserName(String username);

    Boolean checkLogin(LoginRequest user);

    boolean addFilm(String id,String idFilm);
}
