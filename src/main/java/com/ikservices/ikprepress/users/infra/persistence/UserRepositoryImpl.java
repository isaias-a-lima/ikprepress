package com.ikservices.ikprepress.users.infra.persistence;

import com.ikservices.ikprepress.users.domain.model.User;
import com.ikservices.ikprepress.users.domain.repository.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final UserRepositoryJPA jpa;

    public UserRepositoryImpl(UserRepositoryJPA jpa) {
        this.jpa = jpa;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public List<User> listUser() {
        return null;
    }
}
