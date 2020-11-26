package com.project.movie.service.user;

import com.project.movie.dao.UserRepository;
import com.project.movie.document.User;
import com.project.movie.exception.ResourceNotFoundException;
import com.project.movie.payload.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean insertUser(User user) {
        user.setRoles(Arrays.asList("ROLE_USER"));
        user.setIsActive(false);
        System.out.println(user);
        return userRepository.save(user) instanceof User ? true : false;
    }

    @Override
    public boolean updateUser(User user) {
        User user1 = userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setBirthDay(user.getBirthDay());
        user1.setCreate_At(user.getCreate_At());
        user1.setModify_At(user.getModify_At());
        user1.setEmail(user.getEmail());
        user1.setMember(user.getMember());
        user1.setPhone(user.getPhone());
        user1.setUserName(user.getUserName());
        user1.setRoles(user.getRoles());
        user1.setSaved_video(user.getSaved_video());
        user1.setIsActive(user.getIsActive());
        return userRepository.save(user1) instanceof User;
    }

    @Override
    public void delUser(String user) {
        User user1 = userRepository.findById(user).orElseThrow(ResourceNotFoundException::new);
        userRepository.deleteById(user1.getId());
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsUserByUserName(String username) {
        return userRepository.existsUserByUserName(username);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public User loadUserByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Boolean checkLogin(LoginRequest user) {
        return userRepository.findByUserNameAndPassword(user.getUsername(), user.getPassword()) != null;
    }

    @Override
    public boolean addFilm(String id, String idFilm) {
        User user1 = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        if(user1.getSaved_video() == null){
            user1.setSaved_video(Arrays.asList(idFilm));
        }
        else{
            if(user1.getSaved_video().contains(idFilm)){
                user1.setSaved_video(user1.getSaved_video());
            }else{
                user1.getSaved_video().add(idFilm);
            }
        }
        return userRepository.save(user1) instanceof User;
    }
}
