package com.ikservices.ikprepress.users.infra.config;

import com.ikservices.ikprepress.users.application.usecase.ListUser;
import com.ikservices.ikprepress.users.infra.mapper.UserMapper;
import com.ikservices.ikprepress.users.infra.persistence.UserRepositoryImpl;
import com.ikservices.ikprepress.users.infra.persistence.UserRepositoryJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ikservices.ikprepress.users.application.usecase.SaveUser;
import com.ikservices.ikprepress.users.application.usecase.UpdateUser;
import com.ikservices.ikprepress.users.domain.repository.UserRepository;

@Configuration
@PropertySource(name = "users.properties", value = "classpath:users.properties", encoding = "UTF-8")
public class UserConfig {

	@Bean
	public UserRepository getRepository(UserRepositoryJPA jpa, UserMapper userMapper) {
		return new UserRepositoryImpl(jpa, userMapper);
	}

	@Bean
	public SaveUser getSaveUser(UserRepository repository) {
		return new SaveUser(repository);
	}

	@Bean
	public ListUser getListUser(UserRepository repository) {
		return new ListUser(repository);
	}
	
	@Bean
	public UpdateUser UpdateUser(UserRepository repository) {
		return new UpdateUser(repository);
	}
	
	@Bean
	public UserMapper getUserMapper() {
		return new UserMapper();
	}

}
