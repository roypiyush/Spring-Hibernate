package com.personal.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.personal.spring.springbeans.impl.CsvOutputGenerator;

@Configuration
public class AppConfig {

	@Bean(name = "CsvOutputHelper")
	public CsvOutputGenerator getGenerator() {
		return new CsvOutputGenerator();
	}
}
