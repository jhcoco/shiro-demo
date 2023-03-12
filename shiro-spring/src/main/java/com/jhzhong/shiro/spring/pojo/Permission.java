package com.jhzhong.shiro.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: jhzhong
 * @date: 2023/3/12 17:06
 * @desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private String pid;
    private String permsType;
    private String permsName;
    private String status;
    private Date createTime;
    private Date updateTime;
}
