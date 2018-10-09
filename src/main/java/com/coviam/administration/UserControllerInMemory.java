package com.coviam.administration;

import com.coviam.administration.model.UserRecord;
import com.coviam.administration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Access Users using UI/Postman requests.
Data will be saved in application in-memory
 */

@RestController
@RequestMapping("/inMemory")
public class UserControllerInMemory {

    @Autowired
    @Qualifier("com.coviam.administration.service.UserServiceImpl")
    private UserService userService;

    @RequestMapping("/allUsers")
    public List<UserRecord> getAllUser(){
        return userService.getAllUsers();
    }

    @RequestMapping(value="/add-user", method= RequestMethod.POST)
    public void addUser(@RequestBody UserRecord userRecord){
        userService.addUser(userRecord);
    }
    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    public UserRecord getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
}
