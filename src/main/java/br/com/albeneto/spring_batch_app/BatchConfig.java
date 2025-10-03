package br.com.albeneto.spring_batch_app;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Bean
    Job exemploJob(JobRepository jobRepository, Step step) {
    	return new JobBuilder("mensagemJob", jobRepository)
    			.start(step)
    			.build();
    }

    @Bean
    Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("mensagemStep", jobRepository)
        		.tasklet((contribution, chunkContext) -> {
        			System.out.println("******** Meu primeiro Job **********");
        			return RepeatStatus.FINISHED;
        		}, transactionManager)
        		.build();
    }
    
}
