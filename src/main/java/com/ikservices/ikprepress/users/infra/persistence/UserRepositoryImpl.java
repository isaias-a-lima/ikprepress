package com.ikservices.ikprepress.users.infra.persistence;

import com.ikservices.ikprepress.users.domain.model.User;
import com.ikservices.ikprepress.users.domain.repository.UserRepository;
import com.ikservices.ikprepress.users.infra.mapper.UserMapper;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final UserRepositoryJPA jpa;
    private final UserMapper userMapper;
    
    public UserRepositoryImpl(UserRepositoryJPA jpa, UserMapper userMapper) {
        this.jpa = jpa;
        this.userMapper = userMapper;
    }

    @Override
    public User saveUser(User user) {
        return userMapper.parseEntityToDomain(jpa.save(userMapper.parseDomainToEntity(user)));
    }

    @Override
    public List<User> listUser(Boolean activated) {
        List<UserEntity> users = jpa.findByActivated(activated);
        return userMapper.parseEntityToDomainList(users);
    }
}
