package com.git.service;

import java.util.List;

import com.git.domain.UserEntity;

public interface UserService {

	void add(UserEntity userEntity) throws Exception;

	UserEntity check(UserEntity userEntity);

	UserEntity getUserById(Integer attribute);

	void update(UserEntity userEntity);

	void addAll(List<UserEntity> userEntities);

}
