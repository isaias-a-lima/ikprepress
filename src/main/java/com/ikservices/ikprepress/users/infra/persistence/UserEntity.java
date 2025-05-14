package com.ikservices.ikprepress.users.infra.persistence;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "USERS")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "ID_DOC")
	private String idDoc;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "USER_EMAIL")
	private String userEmail;
	
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	
	@Column(name = "CREATION_DATE")
	private LocalDate creationDate;
	
	@Column(name = "ACTIVATED")
	private Boolean activated;
	
	public void update(UserEntity entity) {
		if(Objects.nonNull(entity.getIdDoc())) {
			this.idDoc = entity.getIdDoc();
		}
		if(Objects.nonNull(entity.getUserName())) {
			this.userName = entity.getUserName();
		}
		if(Objects.nonNull(entity.getUserEmail())) {
			this.userEmail = entity.getUserEmail();
		}
		if(Objects.nonNull(entity.getUserPassword())) {
			this.userPassword = entity.getUserPassword();
		}
		if(Objects.nonNull(entity.getCreationDate())) {
			this.activated = entity.getActivated();
		}
	}
}
