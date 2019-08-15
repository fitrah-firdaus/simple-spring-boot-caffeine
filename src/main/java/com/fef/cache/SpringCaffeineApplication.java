package com.fef.cache;

import com.fef.cache.model.Configuration;
import com.fef.cache.repository.ConfigurationDB;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCaffeineApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCaffeineApplication.class, args);
    }
}
