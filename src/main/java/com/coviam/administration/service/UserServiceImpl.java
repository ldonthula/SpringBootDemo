package com.coviam.administration.service;

import com.coviam.administration.dao.UserDaoInMemory;
import com.coviam.administration.model.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
@Component(value="com.coviam.administration.service.UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoInMemory userDaoInMemory;

    @Override
    public List<UserRecord> getAllUsers() {
        List<UserRecord> userRecords = new ArrayList<>();
        userDaoInMemory.findAll().forEach(userRecords::add);
        return userRecords;
    }

    @Override
    public void addUser(UserRecord userRecord) {
        userDaoInMemory.save(userRecord);
    }

    public void delete(Long id){
        userDaoInMemory.deleteById(id);
    }

    @Override
    public UserRecord getUser(Long id) {
        return userDaoInMemory.findById(id).get();
    }
}
