package com.coviam.administration.service;

import com.coviam.administration.dao.UserDaoRedis;
import com.coviam.administration.model.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component(value = "com.coviam.administration.service.UserServiceImplRedis")
public class UserServiceImplRedis implements UserService{

    @Autowired
    private UserDaoRedis userDaoRedis;

    @Override
    public List<UserRecord> getAllUsers() {
        List<UserRecord> userRecords = new ArrayList<>();
        userDaoRedis.findAll().forEach(userRecords::add);
        return userRecords;
    }

    @Override
    public void addUser(UserRecord userRecord) {
        userDaoRedis.save(userRecord);
    }

    public void delete(Long id){
        userDaoRedis.delete(id);
    }

    @Override
    public UserRecord getUser(Long id) {
        return userDaoRedis.findOne(id);
    }
}
