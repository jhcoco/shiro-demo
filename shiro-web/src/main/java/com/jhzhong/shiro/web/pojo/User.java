package com.jhzhong.shiro.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer id;
    private String loginName;
    private String password;
}
