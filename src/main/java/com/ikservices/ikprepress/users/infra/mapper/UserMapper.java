package com.ikservices.ikprepress.users.infra.mapper;

import com.ikservices.ikprepress.commons.generics.IKMapper;
import com.ikservices.ikprepress.commons.utils.DateUtil;
import com.ikservices.ikprepress.users.application.dto.UserDTO;
import com.ikservices.ikprepress.users.domain.model.User;
import com.ikservices.ikprepress.users.infra.persistence.UserEntity;

public class UserMapper extends IKMapper<UserDTO, User, UserEntity, UserDTO>{

	@Override
	public User parseRequestToDomain(UserDTO request) {
		User user = new User();
		
		user.setUserId(request.getUserId());
		user.setIdDoc(request.getIdDoc());
		user.setUserEmail(request.getUserEmail());
		user.setUserName(request.getUserName());
		user.setUserPassword(request.getUserPassword());
		user.setCreationDate(DateUtil.parseToLocalDate(request.getCreationDate()));
		user.setActivated(request.getActivated());
		
		return user;
	}

	@Override
	public UserEntity parseDomainToEntity(User domain) {
		
		UserEntity userEntity = new UserEntity();
		
		userEntity.setUserId(domain.getUserId());
		userEntity.setIdDoc(domain.getIdDoc());
		userEntity.setUserEmail(domain.getUserEmail());
		userEntity.setUserPassword(domain.getUserPassword());
		userEntity.setCreationDate(domain.getCreationDate());
		userEntity.setActivated(domain.getActivated());
		
		return userEntity;
	}

	@Override
	public User parseEntityToDomain(UserEntity entity) {
		
		User user = new User();
		
		user.setUserId(entity.getUserId());
		user.setIdDoc(entity.getIdDoc());
		user.setUserEmail(entity.getUserEmail());
		user.setUserPassword(entity.getUserPassword());
		user.setCreationDate(entity.getCreationDate());
		user.setActivated(entity.getActivated());
		
		return user;
	}

	@Override
	public UserDTO parseDomainToResponse(User domain) {
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(domain.getUserId());
		userDTO.setIdDoc(domain.getIdDoc());
		userDTO.setUserEmail(domain.getUserEmail());
		userDTO.setUserPassword(domain.getUserPassword());
		userDTO.setCreationDate(domain.getCreationDate().toString());
		userDTO.setActivated(domain.getActivated());
		
		return userDTO;
	}
}
