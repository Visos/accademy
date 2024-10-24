package com.betacom.sbb.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.betacom.sbb.general.DataToProcess;
import com.betacom.sbb.listener.JobListener;
import com.betacom.sbb.process.MyProcess;
import com.betacom.sbb.reader.MyReader;
import com.betacom.sbb.writer.MyWriter;

@Configuration
public class JobConfiguration {

    @Bean
    public MyReader reader() {
        return new MyReader();
    }

    @Bean
    public MyProcess process() {
        return new MyProcess();
    }

    @Bean
    public MyWriter writer() {
        return new MyWriter();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
                .<DataToProcess, DataToProcess> chunk(1, transactionManager)
                .reader(reader())
                .processor(process())
                .writer(writer())
                .build();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("myJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener( new JobListener())
                .flow(step1(jobRepository, transactionManager))
                .end()
                .build();
    }

}
