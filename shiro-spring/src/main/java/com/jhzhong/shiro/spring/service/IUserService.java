package com.jhzhong.shiro.spring.service;

import com.jhzhong.shiro.spring.pojo.User;

public interface IUserService {
    User queryUserByLoginName(String principal);
}
