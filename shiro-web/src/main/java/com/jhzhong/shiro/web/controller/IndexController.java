package com.jhzhong.shiro.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jhzhong
 * @ProjectName shiro-demo
 * @createTime 2023/3/11
 * @Desc TODO
 */
@Controller
public class IndexController {

    /**
     * 跳转到首页
     * @return
     */
    @GetMapping(value = {"/", "/index"})
    public String indexPage(){
        return "index";
    }

    @GetMapping(value = "toRegisterPage")
    public String toRegisterPage(){
        return "register";
    }
}
