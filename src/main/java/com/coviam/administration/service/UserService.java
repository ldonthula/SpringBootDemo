package com.coviam.administration.service;

import com.coviam.administration.model.UserRecord;

import java.util.List;


public interface UserService {

    List<UserRecord> getAllUsers();

    void addUser(UserRecord userRecord);

    UserRecord getUser(Long id);
}
