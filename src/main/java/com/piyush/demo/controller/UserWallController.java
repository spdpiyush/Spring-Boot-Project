package com.piyush.demo.controller;

import com.piyush.demo.Dao.UserDao;
import com.piyush.demo.Dao.UserWallDao;
import com.piyush.demo.model.UserWall;
import com.piyush.demo.modelVO.ErrorCodes;
import com.piyush.demo.modelVO.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wall")
public class UserWallController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserWallController.class);

    @Autowired
    private UserWallDao userWallDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private Status status;

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity createPost(@RequestBody UserWall userWall) throws Exception{
        LOGGER.info("Create Post Controller Called");
        try {
            if(userDao.findOne(userWall.getUserId()) == null){
                status.setErrorCodes(ErrorCodes.USER_NOT_PRESENT.getValue());
                status.setMessage(ErrorCodes.USER_NOT_PRESENT.toString());
                LOGGER.info("UserId {} doesn't exist in UserProfile",userWall.getUserId());
            }else {
                userWallDao.save(userWall);
                status.setErrorCodes(ErrorCodes.POST_CREATED_SUCCESS.getValue());
                status.setMessage(ErrorCodes.POST_CREATED_SUCCESS.toString());
                LOGGER.info("Successfully Post Inserted");
            }
        }catch (Exception e){
            LOGGER.error("Error Occured in Create Post {}",e.fillInStackTrace());
            status.setErrorCodes(ErrorCodes.ERROR_IN_POST_CREATE.getValue());
            status.setMessage(ErrorCodes.ERROR_IN_POST_CREATE.toString());
        }
        return ResponseEntity.ok().body(status);
    }
}
