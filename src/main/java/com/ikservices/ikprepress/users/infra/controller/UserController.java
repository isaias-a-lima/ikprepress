package com.ikservices.ikprepress.users.infra.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ikservices.ikprepress.commons.constants.IKConstant;
import com.ikservices.ikprepress.commons.enumerates.IKMessageTypeEnum;
import com.ikservices.ikprepress.commons.exceptions.IKExceptions;
import com.ikservices.ikprepress.commons.response.IKResponse;
import com.ikservices.ikprepress.commons.vo.IKMessageVO;
import com.ikservices.ikprepress.users.application.dto.UserDTO;
import com.ikservices.ikprepress.users.application.usecase.SaveUser;
import com.ikservices.ikprepress.users.domain.model.User;
import com.ikservices.ikprepress.users.infra.mapper.UserMapper;

@RestController
@RequestMapping("users")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	private UserMapper userMapper;
	private SaveUser saveUser;
	
	public UserController(SaveUser saveUser, UserMapper userMapper) {
		this.userMapper = userMapper;
		this.saveUser = saveUser;
	}
	
	@PostMapping
	public ResponseEntity<IKResponse<UserDTO>> saveUser(@RequestBody UserDTO userDTO, UriComponentsBuilder uriBuilder) {
		try {
			User user = userMapper.parseRequestToDomain(userDTO);
			User savedUser = saveUser.execute(user);
			URI uri = uriBuilder.path("get/{userId}").buildAndExpand(savedUser.getUserId()).toUri();
			return ResponseEntity.created(uri).body(IKResponse.<UserDTO>build().
					body(userMapper.parseDomainToResponse(savedUser)).addMessage(new IKMessageVO(IKConstant.DEFAULT_SUCCESS_CODE, 
							IKMessageTypeEnum.SUCCESS, IKConstant.SAVE_SUCCESS_MESSAGE)));
		}catch(IKExceptions ike) {
			LOGGER.error(ike.getMessage(), ike);
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(IKResponse.<UserDTO>build().addMessage(ike.getIkMessage()));
		}catch(Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(IKResponse.<UserDTO>build().addMessage(
					new IKMessageVO(IKConstant.DEFAULT_ERROR_CODE, IKMessageTypeEnum.ERROR, IKConstant.SAVE_ERROR_MESSAGE)));
		}
	}
}
