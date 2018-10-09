package com.coviam.administration.service;

import com.coviam.administration.dao.UserDaoMongoDB;
import com.coviam.administration.model.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component(value = "com.coviam.administration.service.UserServiceImplMongoDB")
public class UserServiceImplMongoDB implements UserService{

    @Autowired
    private UserDaoMongoDB userDaoMongoDB;

    @Override
    public List<UserRecord> getAllUsers() {
        List<UserRecord> userRecords = new ArrayList<>();
        userDaoMongoDB.findAll().forEach(userRecords::add);
        return userRecords;
    }

    @Override
    public void addUser(UserRecord userRecord) {
        userDaoMongoDB.save(userRecord);
    }

    public void delete(Long id){
        userDaoMongoDB.deleteById(id);
    }

    @Override
    public UserRecord getUser(Long id) {
        return userDaoMongoDB.findById(id).get();
    }
}
