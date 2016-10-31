package com.git.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.git.domain.UserEntity;
import com.git.mapper.UserMapper;
import com.git.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public void add(UserEntity userEntity) throws Exception {
		int insert = this.userMapper.insertSelective(userEntity);
		if (insert != 1) {
			throw new Exception("增加用户异常！");
		}
	}

}
