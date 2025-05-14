package com.ikservices.ikprepress.users.application.usecase;

import com.ikservices.ikprepress.users.domain.model.User;
import com.ikservices.ikprepress.users.domain.repository.UserRepository;

public class UpdateUser {
	private final UserRepository repository;
	
	public UpdateUser(UserRepository repository) {
		this.repository = repository;
	}
	
	public User execute(User user) {
		return repository.updateUser(user);
	}
}
