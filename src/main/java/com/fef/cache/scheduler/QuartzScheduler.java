package com.fef.cache.scheduler;

import com.fef.cache.service.ConfigurationCacheService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

@Component
public class QuartzScheduler {
    private final ConfigurationCacheService configurationCacheService;

    public QuartzScheduler(ConfigurationCacheService configurationCacheService) {
        this.configurationCacheService = configurationCacheService;
    }

    public void createScheduler() {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();

            // Create Scheduler for Configuration Loader
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("configurationCacheService", configurationCacheService);
            JobDetail configurationJob = JobBuilder.newJob(ConfigurationJob.class).withIdentity("configurationJob", "groupJob").usingJobData(jobDataMap).build();
            Trigger configurationTrigger = TriggerBuilder.newTrigger().withIdentity("configurationTrigger", "groupJob").startNow().
                    withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(60).repeatForever()).build();
            scheduler.scheduleJob(configurationJob, configurationTrigger);

            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
