package com.jhzhong.shiro.spring.dao;

import com.jhzhong.shiro.spring.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author jhzhong
 * @ProjectName shiro-demo
 * @createTime 2023/3/12
 * @Desc TODO
 */
public interface IRoleDao {
    List<String> getAllRolesByLoginName(@Param(value = "principal") String principal);
}
