package br.com.albeneto.spring_batch_app.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class ImprimeOlaTasklet implements Tasklet {

    @Value("#{jobParameters['nome']}")
    private String meuParametro;	
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println((String.format("Olá, %s!", meuParametro)));
		return RepeatStatus.FINISHED;
	}

}
