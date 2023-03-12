package com.jhzhong.shiro.spring.service;

import com.jhzhong.shiro.spring.pojo.User;
import org.springframework.stereotype.Service;

public interface IUserService {
    User getUserInfoByLoginName(String principal);

    Boolean insertUser(User user);
}
