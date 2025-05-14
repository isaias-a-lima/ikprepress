package com.ikservices.ikprepress.users.domain.repository;

import com.ikservices.ikprepress.users.domain.model.User;

import java.util.List;

public interface UserRepository {
	User saveUser(User user);
	List<User> listUser(Boolean activated);
	User updateUser(User user);
}
