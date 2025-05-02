package com.ikservices.ikprepress.users.application.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDTO {
	private Long userId;
	private String idDoc;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String creationDate;
	private Boolean activated;
}
