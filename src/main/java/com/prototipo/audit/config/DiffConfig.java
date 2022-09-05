package com.prototipo.audit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prototipo.audit.util.Diff;

@Configuration
public class DiffConfig {
	
	@Bean
	Diff diff() {
		return new Diff();
	}
}
