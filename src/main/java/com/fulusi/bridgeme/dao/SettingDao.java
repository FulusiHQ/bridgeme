package com.fulusi.bridgeme.dao;

import java.util.Optional;

import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.fulusi.bridgeme.model.Setting;

@Repository
public interface SettingDao extends MongoRepository<Setting, String> {
    
    Optional<Setting> findByName(String name);

    boolean existsByName(String name);

    boolean existsByNameAndVersion(String name, int version);

    void deleteByNameAndVersion(String name, int version);

    @Query("{ name: ?0 }")
    void updateSettingByName(String name, Update update);
}
