package com.jhzhong.shiro.spring.service;

import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author jhzhong
 * @ProjectName shiro-demo
 * @createTime 2023/3/12
 * @Desc TODO
 */
public interface IPermsService {
    Set<String> getAllPermsByLoginName(String principal);
}
