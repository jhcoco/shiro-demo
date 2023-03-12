package com.jhzhong.shiro.spring.service.impl;

import com.jhzhong.shiro.spring.dao.IPermsDao;
import com.jhzhong.shiro.spring.service.IPermsService;
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
public class PermsServiceImpl implements IPermsService {
    @Autowired
    private IPermsDao permsDao;
    @Override
    public Set<String> getAllPermsByLoginName(String principal) {
        List<String> perms = permsDao.getAllPermsByLoginName(principal);
        return new HashSet<String>(perms);
    }
}
