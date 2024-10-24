package com.betacom.sbb.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobListener implements JobExecutionListener{
	
	private static Logger log = LoggerFactory.getLogger(JobListener.class);
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.debug("job started at: " + jobExecution.getStartTime());
		
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		log.debug("job finished at: " + jobExecution.getStatus());
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("job finished whit sucess at " + jobExecution.getEndTime());
			//process in caso di successo
		}
		if(jobExecution.getStatus() == BatchStatus.FAILED) {
			log.info("job faild at " + jobExecution.getEndTime());
			//process in caso di insuccesso
		}
			
	}

}
