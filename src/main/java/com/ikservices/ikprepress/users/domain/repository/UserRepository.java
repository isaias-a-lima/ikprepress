package com.ikservices.ikprepress.users.domain.repository;

import com.ikservices.ikprepress.users.domain.model.User;

public interface UserRepository {
	User saveUser(User user);
}
