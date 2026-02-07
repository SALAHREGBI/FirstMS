package com.jobintech.SpringMS.repositories;

import com.jobintech.SpringMS.model.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBUserRepository extends JpaRepository<DBUser,Integer> {
    public DBUser findByUsername(String username);
}
