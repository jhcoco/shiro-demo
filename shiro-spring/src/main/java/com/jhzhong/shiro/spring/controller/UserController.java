package com.jhzhong.shiro.spring.controller;

import com.jhzhong.shiro.spring.pojo.User;
import com.jhzhong.shiro.spring.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jhzhong
 * @ProjectName shiro-demo
 * @createTime 2023/3/11
 * @Desc TODO
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 用户登陆逻辑
     * @param user 用户信息
     * @param rememberMe 是否 记住我
     * @return
     */
    @PostMapping(value = "login")
    public String login(User user, String rememberMe){
        // 1. 使用 SecurityUtils.getSubject() 获取 subject
        Subject subject = SecurityUtils.getSubject();
        // 2. 封装 AuthenticationToken 登陆令牌
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
        // 3.记住我
        if (null != rememberMe){
            token.setRememberMe(true);
        }
        // 3. 传入 token 进行安全校验
        subject.login(token);
        return "success";
    }

    @PostMapping(value = "register")
    public String registerUser(User user){
        Boolean flag = userService.insertUser(user);
        return flag  ? "index" : "register";
    }
    @GetMapping(value = "logout")
    public void logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    @GetMapping(value = "details")
    public String detailPage(){
        return "details";
    }
}
