package com.coviam.administration.service;

import com.coviam.administration.dao.UserDaoMongoDB;
import com.coviam.administration.dao.UserDaoPostgres;
import com.coviam.administration.model.UserRecord;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component(value = "com.coviam.administration.service.UserServiceImplPostgres")
public class UserServiceImplPostgres implements UserService{

    @Autowired
    private UserDaoPostgres userDaoPostgres;

    @Override
    public List<UserRecord> getAllUsers() {
        List<UserRecord> userRecords = new ArrayList<>();
        userDaoPostgres.findAll().forEach(userRecords::add);
        return userRecords;
    }

    @Override
    public void addUser(UserRecord userRecord) {
        userDaoPostgres.save(userRecord);
    }

    public void delete(Long id){
        userDaoPostgres.deleteById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "reliable")
    public UserRecord getUser(Long id) {
        return userDaoPostgres.findById(id).get();
    }

    public void reliable(){
        return;
    }

}
