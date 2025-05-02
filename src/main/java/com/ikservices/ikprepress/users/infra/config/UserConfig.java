package com.ikservices.ikprepress.users.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ikservices.ikprepress.users.application.usecase.SaveUser;
import com.ikservices.ikprepress.users.domain.repository.UserRepository;

@Configuration
@PropertySource(name = "users.properties", value = "classpath:users.properties", encoding = "UTF-8")
public class UserConfig {
	
	@Bean
	public SaveUser saveUser(UserRepository repository) {
		return new SaveUser(repository);
	}
}
