package com.jhzhong.shiro.spring.dao;

import com.jhzhong.shiro.spring.pojo.User;

public interface IUserDao {
    User queryUserByLoginName(String principal);
}
