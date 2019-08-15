package com.fef.cache.controller;

import com.fef.cache.model.Configuration;
import com.fef.cache.service.ConfigurationCacheService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {
    private final ConfigurationCacheService configurationCacheService;

    public ConfigurationController(ConfigurationCacheService configurationCacheService) {
        this.configurationCacheService = configurationCacheService;
    }

    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Configuration> getAll() {
        return configurationCacheService.getAll();
    }
}
