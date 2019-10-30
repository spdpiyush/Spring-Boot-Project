package com.piyush.demo.controller;

/**
 * Created By : Piyush Kumar
 */

import com.piyush.demo.Dao.UserDao;
import com.piyush.demo.model.User;
import com.piyush.demo.modelVO.ErrorCodes;
import com.piyush.demo.modelVO.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/piyush")
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private Status status;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    //To Save a Single User
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody(required = true) User user) throws Exception{

        LOGGER.info("Create User Controller Called ");

        try {
            userDao.save(user);
            status.setErrorCodes(200);
            status.setMessage("Success");
            LOGGER.info("User: {} saved",user);
        }catch (Exception e){
            LOGGER.error(String.valueOf(e.fillInStackTrace()));
            status.setErrorCodes(ErrorCodes.ERROR_IN_PUT_USER.getValue());
            status.setMessage(ErrorCodes.ERROR_IN_PUT_USER.toString());
        }
        return ResponseEntity.ok().body(status);
    }

    //To Save List of Users
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity createUsers(List<User> users) throws Exception{
        LOGGER.info("Create Users Controller Called");
        try {
            userDao.saveAll(users);
            status.setErrorCodes(200);
            status.setMessage("Success");
            for(User user:users){
                LOGGER.info("User : {} saved",user);
            }
        }catch (Exception e){
            LOGGER.error(String.valueOf(e.fillInStackTrace()));
            status.setErrorCodes(ErrorCodes.ERROR_IN_PUT_USERS.getValue());
            status.setMessage(ErrorCodes.ERROR_IN_PUT_USERS.toString());
        }
        return ResponseEntity.ok().body(status);
    }

    //To Get a User By Its UserId
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity getUserById(@PathVariable Long userId) throws Exception{
        LOGGER.info("Get User by its UserId Called");
        try {
            User user = userDao.findOne(userId);
            if(user == null){
                status.setErrorCodes(ErrorCodes.USER_NOT_PRESENT.getValue());
                status.setMessage(ErrorCodes.USER_NOT_PRESENT.toString());
                LOGGER.info("No User with that {} userId",userId);
            }
            else {
                return ResponseEntity.ok().body(user);
            }
        }catch (Exception e){
            LOGGER.error(String.valueOf(e.fillInStackTrace()));
            status.setErrorCodes(ErrorCodes.ERROR_IN_GET_USER.getValue());
            status.setMessage(ErrorCodes.ERROR_IN_GET_USER.toString());
        }
        return ResponseEntity.ok().body(status);
    }

    //To Get all the Users
    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public ResponseEntity getAll() throws Exception{
        LOGGER.info("Get all User is Called");
        try {
            List<User> users = userDao.getAll();
            if(users == null){
                status.setErrorCodes(ErrorCodes.NO_USERS_PRESENT.getValue());
                status.setMessage(ErrorCodes.NO_USERS_PRESENT.toString());
                LOGGER.info("No Users Present");
            }else {
                return ResponseEntity.ok().body(users);
            }
        }catch (Exception e){
            LOGGER.error(String.valueOf(e.fillInStackTrace()));
            status.setErrorCodes(ErrorCodes.ERROR_IN_GET_USERS.getValue());
            status.setMessage(ErrorCodes.ERROR_IN_GET_USERS.toString());
        }
        return ResponseEntity.ok().body(status);
    }

}
