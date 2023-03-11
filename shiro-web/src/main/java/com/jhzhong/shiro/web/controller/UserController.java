package com.jhzhong.shiro.web.controller;

import com.jhzhong.shiro.web.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jhzhong
 * @ProjectName shiro-demo
 * @createTime 2023/3/11
 * @Desc TODO
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {

    @PostMapping(value = "login")
    public String login(User user){
        // 1. 使用 SecurityUtils.getSubject() 获取 subject
        Subject subject = SecurityUtils.getSubject();
        // 2. 封装 AuthenticationToken 登陆令牌
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
        // 3. 传入 token 进行安全校验
        subject.login(token);
        return "success";
    }
}
