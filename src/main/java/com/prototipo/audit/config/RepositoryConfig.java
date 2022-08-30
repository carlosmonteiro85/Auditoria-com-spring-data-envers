package com.prototipo.audit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaAuditing
@EnableEnversRepositories(basePackages = {"com.prototipo.audit.repository"})
@EnableTransactionManagement
public class RepositoryConfig {

	@Bean
	String auditotProvider(){
		return "Auditor";
	}
}
