package com.piyush.demo.Dao;

/**
 * Created By : Piyush Kumar
 */

import com.piyush.demo.model.User;
import com.piyush.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    // To Save an Single User
    public User save(User user){
        return userRepository.save(user);
    }

    //To Save List / Multiple Users
    public List<User> saveAll(List<User> users){
        return userRepository.saveAll(users);
    }

    //To Search The User by their userId
    public User findOne(Long userId){
        return userRepository.findByUserId(userId);
    }

    //To Get all the Users
    public List<User> getAll(){
        return userRepository.findAll();
    }

    public void delete(User user){
        userRepository.delete(user);
    }
}
