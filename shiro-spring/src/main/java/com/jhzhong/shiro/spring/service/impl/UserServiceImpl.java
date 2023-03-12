package com.jhzhong.shiro.spring.service.impl;

import com.jhzhong.shiro.spring.dao.IUserDao;
import com.jhzhong.shiro.spring.pojo.User;
import com.jhzhong.shiro.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: jhzhong
 * @date: 2023/3/12 17:02
 * @desc:
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    public User queryUserByLoginName(String principal) {
        return userDao.queryUserByLoginName(principal);
    }
}
