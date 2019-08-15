package com.fef.cache.service;

import com.fef.cache.model.Configuration;

import java.util.Map;

public interface ConfigurationCacheService {
    void put(Configuration configuration);

    Configuration get(String key);

    Map<String, Configuration> getAll();

    void remove(String key);

    void putAll();
}
