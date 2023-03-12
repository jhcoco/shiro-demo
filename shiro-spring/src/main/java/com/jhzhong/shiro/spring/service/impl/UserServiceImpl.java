package com.jhzhong.shiro.spring.service.impl;

import com.jhzhong.shiro.spring.dao.IUserDao;
import com.jhzhong.shiro.spring.pojo.User;
import com.jhzhong.shiro.spring.service.IUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author: jhzhong
 * @date: 2023/3/12 17:02
 * @desc:
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public User getUserInfoByLoginName(String principal) {
        return userDao.getUserInfoByLoginName(principal);
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Override
    public Boolean insertUser(User user) {
        User byLoginName = userDao.getUserInfoByLoginName(user.getLoginName());
        if (null != byLoginName){
            return false;
        }
        String salt = UUID.randomUUID().toString();
        Date currentTime = new Date();
        user.setSalt(salt);
        user.setCreateTime(currentTime);
        user.setUpdateTime(currentTime);
        // 密码 md5 加密存储
        String md5HashPW = new Md5Hash(user.getPassword(),salt,1024).toBase64();
        user.setPassword(md5HashPW);
        Integer rows = userDao.insertUser(user);
        return rows > 0 ? true : false;
    }
}
