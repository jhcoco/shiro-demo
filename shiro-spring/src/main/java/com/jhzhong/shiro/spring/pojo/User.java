package com.jhzhong.shiro.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author jhzhong
 * @ProjectName shiro-demo
 * @createTime 2023/3/11
 * @Desc TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uid;
    private String loginName;
    private String username;
    private String password;
    private String salt;
    private String status;
    private Date createTime;
    private Date updateTime;
}
