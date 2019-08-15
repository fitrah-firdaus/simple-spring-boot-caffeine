package com.fef.cache;

import com.fef.cache.service.ConfigurationCacheService;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static org.junit.Assert.assertEquals;

@DataMongoTest
@EnableMongoRepositories
@AutoConfigureDataMongo
public class ConfigurationCacheServiceTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ConfigurationCacheService configurationCacheService;

    @Before
    public void setUp() throws Exception {
        DBObject objectToSave1 = BasicDBObjectBuilder.start().add("config1", "{ \"label\" : \"test1\"}").get();
        mongoTemplate.save(objectToSave1, "configurations");
    }

    @Test
    public void getCache() {
        configurationCacheService.putAll();

        assertEquals(configurationCacheService.get("config1").getData(),"{ \"label\" : \"test1\"}");
    }
}
