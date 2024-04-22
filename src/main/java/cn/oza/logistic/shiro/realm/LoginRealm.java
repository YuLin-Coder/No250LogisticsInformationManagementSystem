package cn.oza.logistic.shiro.realm;

import cn.oza.logistic.ssm.pojo.Permission;
import cn.oza.logistic.ssm.pojo.PermissionExample;
import cn.oza.logistic.ssm.pojo.User;
import cn.oza.logistic.ssm.pojo.UserExample;
import cn.oza.logistic.ssm.service.PermissionService;
import cn.oza.logistic.ssm.service.UserService;
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

import java.util.ArrayList;
import java.util.List;

public class LoginRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取当前身份
        User user = (User) principals.getPrimaryPrincipal();
        String permissionIdsStr = user.getRole().getPermissionIds();
        String[] ids = permissionIdsStr.split(",");
        List<Long> permissionIds = new ArrayList<>();
        //获取权限ID集合
        for (String id : ids) {
            permissionIds.add(Long.valueOf(id));
        }
        PermissionExample permissionExample = new PermissionExample();
        PermissionExample.Criteria criteria = permissionExample.createCriteria();
        criteria.andPermissionIdIn(permissionIds);
        //获取权限集合
        List<Permission> permissions = permissionService.selectByExample(permissionExample);
        //循环添加权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Permission permission : permissions) {
            simpleAuthorizationInfo.addStringPermission(permission.getExpression());
        }
        //返回授权信息
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取登录用户的用户名
        String username = String.valueOf(token.getPrincipal());

        //数据库搜索用户名对应用户
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userService.selectByExample(userExample);

        //users.size() 不为 0，则用户存在，进行下一步校验
        if (users.size() > 0) {
            //取出用户
            User user = users.get(0);
            user.setRoleName(user.getRole().getRolename());

            //获取密码
            String hashedCredentials = user.getPassword();
            //获取盐
            String salt = user.getSalt();

            return new SimpleAuthenticationInfo(user, hashedCredentials, ByteSource.Util.bytes(salt), this.getName());
        }
        //用户名不存在则返回 null
        return null;
    }
}
