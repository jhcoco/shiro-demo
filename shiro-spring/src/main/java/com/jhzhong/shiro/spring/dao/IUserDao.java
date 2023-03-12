package com.jhzhong.shiro.spring.dao;

import com.jhzhong.shiro.spring.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author jhzhong
 * @ProjectName shiro-demo
 * @createTime 2023/3/12
 * @Desc TODO
 */
public interface IUserDao {
    /**
     * 根据登录名查询用户信息
     * @param principal 登陆令牌（登录名）
     * @return
     */
    User getUserInfoByLoginName(@Param(value = "principal") String principal);

    Integer insertUser(User user);
}
