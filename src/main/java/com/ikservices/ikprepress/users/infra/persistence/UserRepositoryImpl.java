package com.ikservices.ikprepress.users.infra.persistence;

import com.ikservices.ikprepress.commons.constants.IKConstant;
import com.ikservices.ikprepress.commons.exceptions.IKExceptions;
import com.ikservices.ikprepress.commons.vo.IKMessageVO;
import com.ikservices.ikprepress.users.domain.model.User;
import com.ikservices.ikprepress.users.domain.repository.UserRepository;
import com.ikservices.ikprepress.users.infra.mapper.UserMapper;

import java.util.List;
import java.util.Optional;

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

	@Override
	public User updateUser(User user) {
		Optional<UserEntity> optional = this.jpa.findById(user.getUserId());
		
		if(!optional.isPresent()) {
			throw new IKExceptions("Not found");
		}
		
		UserEntity entity = optional.get();
		entity.update(userMapper.parseDomainToEntity(user));
		
		return userMapper.parseEntityToDomain(entity);
	}
}
