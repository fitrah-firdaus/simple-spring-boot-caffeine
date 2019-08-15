package com.fef.cache.loader;

import com.fef.cache.scheduler.QuartzScheduler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CacheLoader implements CommandLineRunner {
    private final QuartzScheduler quartzScheduler;

    public CacheLoader(QuartzScheduler quartzScheduler) {
        this.quartzScheduler = quartzScheduler;
    }

    @Override
    public void run(String... args) throws Exception {
        quartzScheduler.createScheduler();
    }
}
