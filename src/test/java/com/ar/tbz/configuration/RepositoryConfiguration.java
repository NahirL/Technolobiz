package com.ar.tbz.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.ar.tbz.domain"})
@EnableJpaRepositories(basePackages = {"com.ar.tbz.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
