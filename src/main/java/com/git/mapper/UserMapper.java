package com.git.mapper;

import com.git.domain.DemoEntity;
import com.git.domain.UserEntity;
import com.github.abel533.mapper.Mapper;

/**
 * 通用mapper
 * 这个不用增加@Repository注解，因为这个是接口，增加了注解也没用
 * @author wangquan
 *
 */
public interface UserMapper extends Mapper<UserEntity>{

}
