package com.fulusi.bridgeme.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fulusi.bridgeme.model.User;

@Repository
public interface UserDao extends MongoRepository<User, String> {
    
    Optional<User> findByUserName(String name);

    boolean existsByUserName(String name);

}
