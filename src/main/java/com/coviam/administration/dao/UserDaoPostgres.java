package com.coviam.administration.dao;

import com.coviam.administration.model.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDaoPostgres extends JpaRepository<UserRecord, Long> {
}
