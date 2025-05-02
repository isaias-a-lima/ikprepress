package com.ikservices.ikprepress.users.application.usecase;

import com.ikservices.ikprepress.users.domain.model.User;
import com.ikservices.ikprepress.users.domain.repository.UserRepository;

public class SaveUser {
	private final UserRepository repository;
	
	public SaveUser(UserRepository repository) {
		this.repository = repository;
	}
	
	public User execute(User user) {
		return repository.saveUser(user);
	}
}
