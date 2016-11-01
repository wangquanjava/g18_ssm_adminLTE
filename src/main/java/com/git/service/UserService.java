package com.git.service;

import com.git.domain.UserEntity;

public interface UserService {

	void add(UserEntity userEntity) throws Exception;

	boolean check(UserEntity userEntity);

	UserEntity getUserByUsername(String username);

	UserEntity getUserById(Integer attribute);

	void update(UserEntity userEntity);

}
