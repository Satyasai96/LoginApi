package com.info.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Serializable> {
	public UserEntity findByUserEmailAndUserPwd(String userEmail,String userPwd);

}
