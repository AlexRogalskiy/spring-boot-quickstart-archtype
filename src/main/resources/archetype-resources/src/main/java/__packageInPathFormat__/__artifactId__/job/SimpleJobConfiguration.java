package ${package}.${artifactId}.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ${package}.${artifactId}.readers.*;
import ${package}.${artifactId}.processors.*;
import ${package}.${artifactId}.writers.*;
/**
 * Created by id961900 on 09/08/2017.
 */
@Configuration
public class SimpleJobConfiguration{
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job(){
        return jobBuilderFactory.get("job")
            .start(step())
            .build();
    }

    @Bean
    public Step step(){
        return stepBuilderFactory.get("step")
            .<String,String>chunk(1)
            .reader(reader())
            .processor(processor())
            .writer(writer())
            .build();
    }

    @Bean
    public LogItemWriter writer() {
        return new LogItemWriter();
    }

    @Bean
    public LogItemProcessor processor() {
        return new LogItemProcessor();
    }

    @Bean
    public DummyItemReader reader() {
        return new DummyItemReader();
    }

}
