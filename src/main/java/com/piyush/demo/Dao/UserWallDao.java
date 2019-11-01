package com.piyush.demo.Dao;

import com.piyush.demo.model.UserWall;
import com.piyush.demo.repository.UserRepository;
import com.piyush.demo.repository.UserWallRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWallDao {

    @Autowired
    private UserWallRepository userWallRepository;

    // To Save a Post
    public UserWall save(UserWall userWall){
        return userWallRepository.save(userWall);
    }

    //To Save Multiple Post
    public List<UserWall> saveAll(List<UserWall> userWalls){
        return userWallRepository.saveAll(userWalls);
    }

    //To Get Post by postId
    public UserWall findOnePost(Long postId){
        return userWallRepository.findById(postId).orElse(null);
    }

    //To Get All the Post
    public List<UserWall> findAll(){
        return userWallRepository.findAll();
    }

    //To Get Post By userId
    public List<UserWall> findByUserId(Long userId){
        return userWallRepository.findByUserId(userId);
    }

    //To Delete an Post by its postId
    public void deletePost(UserWall userWall){
        userWallRepository.delete(userWall);
    }
}
