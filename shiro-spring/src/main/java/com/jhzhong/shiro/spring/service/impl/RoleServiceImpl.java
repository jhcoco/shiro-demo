package com.jhzhong.shiro.spring.service.impl;

import com.jhzhong.shiro.spring.dao.IRoleDao;
import com.jhzhong.shiro.spring.pojo.Role;
import com.jhzhong.shiro.spring.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jhzhong
 * @ProjectName shiro-demo
 * @createTime 2023/3/12
 * @Desc TODO
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;
    @Override
    public Set<String> getAllRolesByLoginName(String principal) {
        List<String> roles = roleDao.getAllRolesByLoginName(principal);
        return new HashSet<String>(roles);
    }
}
