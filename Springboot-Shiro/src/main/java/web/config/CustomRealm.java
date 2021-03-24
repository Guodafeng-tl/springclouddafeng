package web.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.entity.User;
import web.service.UserService;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : dafeng.guo
 * @date : 10:40 2021/3/24
 **/
@Slf4j
public class CustomRealm extends AuthorizingRealm {

    private UserService userMapper;

    @Autowired
    private void setUserMapper(UserService userMapper) {
        this.userMapper = userMapper;
    }

    /**
     *获取身份验证信息
     *  Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     * @throws Exception
     */

    @Override
    public AuthenticationInfo  doGetAuthenticationInfo(AuthenticationToken authenticationToken){
        log.info("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 从数据库获取对应用户名密码的用户
        User user = userMapper.queryByUserName(token.getUsername());
        if (user == null){
            throw new UnknownAccountException("用户不存在*");
        }
        if (null == user.getPwd()) {
            throw new AccountException("用户名不正确");
        } else if (!user.getPwd().equals(new String((char[]) token.getCredentials()))) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(), user.getPwd(), getName());
    }

    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("————权限认证————");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        String role = userMapper.queryByUserName(username).getRole();
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }
}
