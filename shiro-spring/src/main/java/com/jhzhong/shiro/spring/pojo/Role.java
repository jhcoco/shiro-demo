package com.jhzhong.shiro.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: jhzhong
 * @date: 2023/3/12 17:04
 * @desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String rid;
    private String roleType;
    private String roleName;
    private String status;
    private Date createTime;
    private Date updateTime;
}
