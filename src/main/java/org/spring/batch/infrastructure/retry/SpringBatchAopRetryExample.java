package org.spring.batch.infrastructure.retry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by iurii.dziuban on 19.07.2016.
 */
public class SpringBatchAopRetryExample {

    private static final Log LOGGER = LogFactory.getLog(SpringBatchAopRetryExample.class);

    public static void main( String[] args ) throws Exception {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:retry/retry-application-context.xml"});

        JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);

        Job transactionJob = applicationContext.getBean("transactionJob", Job.class);

        JobExecution jobExecution = jobLauncher.run(transactionJob, new JobParameters());
        LOGGER.info("Exit status = " + jobExecution.getExitStatus());
    }
}