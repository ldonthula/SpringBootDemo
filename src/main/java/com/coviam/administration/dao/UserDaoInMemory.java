package com.coviam.administration.dao;

import com.coviam.administration.model.UserRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/*
CrudRepository stores and retreives information when application is up and running.
stored information will be cleared as soon the applciation is stopped.

Data will be saved in application in-memory
Note: If the postgres
 */
@Service
public interface UserDaoInMemory extends CrudRepository<UserRecord, Long> {

}
