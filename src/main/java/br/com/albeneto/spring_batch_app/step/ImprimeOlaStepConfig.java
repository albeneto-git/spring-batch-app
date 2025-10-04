package br.com.albeneto.spring_batch_app.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ImprimeOlaStepConfig {
	
    @Bean
    Step imprimeOlaStep(JobRepository jobRepository, PlatformTransactionManager transactionManager, Tasklet imprimeOlaTaskLet) {
        return new StepBuilder("mensagemStep", jobRepository)
        		.tasklet(imprimeOlaTaskLet, transactionManager)
        		.build();
    }
}
