package com.jhzhong.shiro.spring.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author jhzhong
 * @ProjectName shiro-demo
 * @createTime 2023/3/12
 * @Desc TODO
 */
public interface IPermsDao {
    List<String> getAllPermsByLoginName(@Param(value = "principal") String principal);
}
