package org.onedatashare.transferservice.odstransferservice.service.listner;

import lombok.SneakyThrows;
import org.onedatashare.transferservice.odstransferservice.service.ConnectionBag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JobCompletionListener extends JobExecutionListenerSupport {
    Logger logger = LoggerFactory.getLogger(JobCompletionListener.class);

    @Autowired
    ConnectionBag connectionBag;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("BEFOR JOB-------------------present time--" + System.currentTimeMillis());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        logger.info("After JOB------------------present time--" + System.currentTimeMillis());
        connectionBag.closePools();
    }
}