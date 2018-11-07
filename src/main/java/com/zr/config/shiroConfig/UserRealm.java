package com.zr.config.shiroConfig;

import com.zr.model.SysPermission;
import com.zr.model.SysRole;
import com.zr.model.SysUser;
import com.zr.service.SysPermissionService;
import com.zr.service.SysRoleService;
import com.zr.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * @Description: 获取授权相关信息
     * @Param: PrincipalCollection, Shiro中同时配置多个Realm，身份信息可能就有多个；PrincipalCollection用于聚合这些身份信息
     * @ReturnType: AuthorizationInfo，  用于聚合授权信息的
     * @Exception
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = UserUtil.getCurrentUser();
        List<SysRole> roles = sysRoleService.selectByuserid(user.getId());
        Set<String> roleNames = roles.stream().map(SysRole::getName).collect(Collectors.toSet());
        authorizationInfo.setRoles(roleNames);
        List<SysPermission> permissionList = sysPermissionService.selectByuserid(user.getId());
        UserUtil.setPermissionSession(permissionList);
        Set<String> permissions = permissionList.stream().filter(p -> !StringUtils.isEmpty(p.getPermission()))
                .map(SysPermission::getPermission).collect(Collectors.toSet());
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * @Description: 身份认证拦截器, 获取身份认证相关信息
     * @Param: AuthenticationToken 用于收集用户提交的身份及凭据
     * @ReturnType: AuthenticationInfo
     * @Exception AuthenticationException
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = (String) token.getPrincipal();
        SysUser user = sysUserService.selectByUsername(username);
        if (user == null || user.getId() == null) {
            throw new UnknownAccountException("用户名不存在");
        }
        if (!user.getPassword()
                .equals(sysUserService.passwordEncoder(new String(usernamePasswordToken.getPassword()), user.getSalt()))) {
            throw new IncorrectCredentialsException("密码错误");
        }
        if (user.getStatus() != SysUser.Status.VALID) {
            throw new IncorrectCredentialsException("无效状态，请联系管理员");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()), getName());
        UserUtil.setUserSession(user);
        return authenticationInfo;
    }

    /**
     * 重写缓存key，否则集群下session共享时，会重复执行doGetAuthorizationInfo权限配置
     */
    @Override
    protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
        SimplePrincipalCollection principalCollection = (SimplePrincipalCollection) principals;
        Object object = principalCollection.getPrimaryPrincipal();

        if (object instanceof SysUser) {
            SysUser user = (SysUser) object;

            return "authorization:cache:key:users:" + user.getId();
        }
        return super.getAuthorizationCacheKey(principals);
    }
}
