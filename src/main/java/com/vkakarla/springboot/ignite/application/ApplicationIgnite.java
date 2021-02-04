package com.vkakarla.springboot.ignite.application;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableIgniteRepositories("com.vkakarla.springboot.ignite.repository")
@ComponentScan(value = "com.vkakarla.springboot.ignite.*")
@SpringBootApplication()
@EnableSwagger2
public class ApplicationIgnite {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationIgnite.class, args);
	}
	
	@Bean
	public Docket saggerapi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.vkakarla.springboot.ignite.controller")).build();
	}

	
	/**
     * Creating Apache Ignite instance bean. A bean will be passed
     * to IgniteRepositoryFactoryBean to initialize all Ignite based Spring Data repositories and connect to a cluster.
     */
    @Bean
    public Ignite igniteInstance() {
    	IgniteConfiguration cfg = new IgniteConfiguration();

        cfg.setClientMode(true);

        return Ignition.start(cfg);
    }

}
