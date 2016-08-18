package org.spring.batch.infrastructure.spring_integration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.scheduler.CronScheduler;
import org.springframework.batch.core.JobExecution;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.mail.MailHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by iurii.dziuban on 17.08.2016.
 */
public class ExecutionsToMailTransformer {

    private static final Log LOGGER = LogFactory.getLog(ExecutionsToMailTransformer.class);

    @Transformer
    public Message<String> transformExecutionsToMail(JobExecution jobExecution) {
        LOGGER.info("Transforming executions to mail");
        String result = "Execution has " + jobExecution.getStatus().toString();
        return MessageBuilder.withPayload(result)
                .setHeader(MailHeaders.TO, "iurii.dziuban@yahoo.ca")
                .setHeader(MailHeaders.FROM, "iurii.dziuban@yahoo.ca").build();
    }
}
