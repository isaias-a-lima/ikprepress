package com.ikservices.ikprepress.users.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, Long>{

}
