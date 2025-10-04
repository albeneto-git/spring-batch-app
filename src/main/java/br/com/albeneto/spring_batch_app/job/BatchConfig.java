package br.com.albeneto.spring_batch_app.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

    @Bean
    Job exemploJob(JobRepository jobRepository, Step imprimeOlaStep) {
    	return new JobBuilder("mensagemJob", jobRepository)
    			.start(imprimeOlaStep)
    			.incrementer(new RunIdIncrementer())
    			.build();
    }

}
