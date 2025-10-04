package br.com.albeneto.spring_batch_app;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

// para rodar tem que descomentar e comentar o outro Job @Configuration
public class ParImparBatchConfig {

	@Bean
	Job imprimeParImparJob(JobRepository jobRepository, Step step, PlatformTransactionManager transactionManager) {
		return new JobBuilder("mensagemJob", jobRepository)
				.start(imprimeParOuImparStep(jobRepository, transactionManager)).incrementer(new RunIdIncrementer())
				.build();
	}

	@Bean
	Step imprimeParOuImparStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("imprimeParOuImparStep", jobRepository).<Integer, String>chunk(1, transactionManager)
				.reader(contaAteDezReader())
				.processor(parOuImparProcessor())
				.writer(imprimeWriter()).build();
	}

	private ItemWriter<String> imprimeWriter() {
		return itens -> itens.forEach(System.out::println);
	}

	private FunctionItemProcessor<Integer, String> parOuImparProcessor() {
		return new FunctionItemProcessor<Integer, String>(
				item -> item % 2 == 0 ? String.format("Item %s é Par", item) : String.format("Item %s é Impar", item));
	}

	private IteratorItemReader<Integer> contaAteDezReader() {
		List<Integer> numerosDeUmAteDez = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		return new IteratorItemReader<Integer>(numerosDeUmAteDez.iterator());
	}

}
