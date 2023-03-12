package com.jhzhong.shiro.spring.realm;

import com.jhzhong.shiro.spring.pojo.User;
import com.jhzhong.shiro.spring.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author: jhzhong
 * @date: 2023/3/12 17:00
 * @desc: 自定义 realm
 */
@Component(value = "myRealm")
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String principal = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        Set<String> roles = userService.queryRolesByLoginName(principal);
//        Set<String> permissions = userService.queryPermsByLoginName(principal);
//        info.setRoles(roles);
//        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 身份认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        User user = userService.queryUserByLoginName(principal);
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(principal, user.getPassword(), getName());
//        return new SimpleAuthenticationInfo(principal, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
    }
}
