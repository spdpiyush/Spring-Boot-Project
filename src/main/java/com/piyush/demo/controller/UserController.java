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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/piyush")
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private Status status;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

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
            status.setErrorCodes(ErrorCodes.USER_NOT_CREATED.getValue());
            status.setMessage(ErrorCodes.USER_NOT_CREATED.toString());
        }
        return ResponseEntity.ok().body(status);
    }


}
