package com.fef.cache.repository;

import com.fef.cache.model.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationDB extends MongoRepository<Configuration, String> {
}
