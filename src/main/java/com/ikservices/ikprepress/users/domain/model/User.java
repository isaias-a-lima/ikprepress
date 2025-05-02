package com.ikservices.ikprepress.users.domain.model;

import java.time.LocalDate;

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
public class User {
	private Long userId;
	private String idDoc;
	private String userName;
	private String userEmail;
	private String userPassword;
	private LocalDate creationDate;
	private Boolean activated;
}
