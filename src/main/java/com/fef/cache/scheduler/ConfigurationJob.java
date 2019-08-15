package com.fef.cache.scheduler;

import com.fef.cache.service.ConfigurationCacheService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(ConfigurationJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap map = jobExecutionContext.getJobDetail().getJobDataMap();
        long startTime = System.currentTimeMillis();
        ConfigurationCacheService configurationCacheService = (ConfigurationCacheService) map.get("configurationCacheService");
        configurationCacheService.putAll();
        long responseTime = System.currentTimeMillis() - startTime;
        System.out.println(String.format("Load configuration success in %d ms", responseTime));
    }
}
