package com.ikservices.ikprepress.users.application.usecase;

import com.ikservices.ikprepress.users.domain.model.User;
import com.ikservices.ikprepress.users.domain.repository.UserRepository;

import java.util.List;

public class ListUser {
    private final UserRepository repository;

    public ListUser(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> execute() {
        return repository.listUser();
    }
}
