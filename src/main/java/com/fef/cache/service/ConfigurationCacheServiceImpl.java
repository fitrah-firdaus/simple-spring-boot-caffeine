package com.fef.cache.service;

import com.fef.cache.model.Configuration;
import com.fef.cache.repository.ConfigurationDB;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ConfigurationCacheServiceImpl implements ConfigurationCacheService {

    private Cache<String, Configuration> configurationCache;

    private final ConfigurationDB configurationDB;

    public ConfigurationCacheServiceImpl(ConfigurationDB configurationDB) {
        this.configurationDB = configurationDB;
        configurationCache = Caffeine.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build();
        putAll();
    }

    @Override
    public void put(Configuration configuration) {
        configurationCache.put(configuration.getId(), configuration);
    }

    @Override
    public Configuration get(String key) {
        return configurationCache.getIfPresent(key);
    }

    @Override
    public Map<String, Configuration> getAll() {
        return configurationCache.asMap();
    }

    @Override
    public void remove(String key) {
        configurationCache.invalidate(key);
    }

    @Override
    public void putAll() {
        List<Configuration> configurationList = configurationDB.findAll();
        for (Configuration configuration : configurationList) {
            put(configuration);
        }
    }
}
