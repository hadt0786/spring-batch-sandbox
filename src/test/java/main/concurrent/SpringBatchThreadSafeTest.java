package main.concurrent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import main.exceptional.SpringBatchComplexRetryTest;

/**
 * Created by iurii.dziuban on 08.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:concurrent/thread-safe-application-context.xml"})
public class SpringBatchThreadSafeTest {

    private static final Log LOGGER = LogFactory.getLog(SpringBatchComplexRetryTest.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() throws Exception {
        JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);
        Job transactionJob = applicationContext.getBean("transactionJob", Job.class);

        JobExecution jobExecution = jobLauncher.run(transactionJob, new JobParameters());
        LOGGER.info("Exit status = " + jobExecution.getExitStatus());
        Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
    }

}