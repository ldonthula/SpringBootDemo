package com.coviam.administration.dao;

import com.coviam.administration.model.UserRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDaoMongoDB extends MongoRepository<UserRecord, Long> {

}
