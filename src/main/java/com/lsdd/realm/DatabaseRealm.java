package com.lsdd.realm;

import com.lsdd.entity.User;
import com.lsdd.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName=(String)principalCollection.getPrimaryPrincipal();

        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取账户密码
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        String userName=token.getPrincipal().toString();
        String password=new String(token.getPassword());

        //获取数据库中的密码
        User user=userService.getByName(userName);
        String passwordInDB=user.getPassword();
        String salt=user.getSalt();
        //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :DatabaseRealm
        //盐也放进去
        //这样通过applicationContext-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
        /*SimpleAuthenticationInfo info=
                new SimpleAuthenticationInfo(userName,passwordInDB, ByteSource.Util.bytes(salt),getName());*/
        //这里用的是applicationContext-shiro里配置的密码匹配器
        SimpleAuthenticationInfo info=
                new SimpleAuthenticationInfo(userName,passwordInDB, ByteSource.Util.bytes(salt),getName());
        return info;
    }
}
