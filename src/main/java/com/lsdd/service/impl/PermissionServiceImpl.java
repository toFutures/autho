package com.lsdd.service.impl;

import com.lsdd.dao.PermissionMapper;
import com.lsdd.entity.Permission;
import com.lsdd.entity.Role;
import com.lsdd.entity.RolePermission;
import com.lsdd.entity.User;
import com.lsdd.service.PermissionService;
import com.lsdd.service.RoleService;
import com.lsdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl  implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;

    @Override
    public Permission selectByPrimaryKey(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Permission record) {
        return permissionMapper.insert(record);
    }

    @Override
    public int insertSelective(Permission record) {
        return permissionMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Permission getByName(String permissionName) {
        return permissionMapper.getByName(permissionName);
    }

    @Override
    public List<Permission> selectListPermission() {
        return permissionMapper.selectListPermission();
    }

    /**
     * shiro基于URL的权限配置新增方法
     * needInterceptor 表示是否要进行拦截，判断依据是如果访问的某个url,在权限系统里存在，就要进行拦截。 如果不存在，就放行了。
     * 这一种策略，也可以切换成另一个，即，访问的地址如果不存在于权限系统中，就提示没有拦截。 这两种做法没有对错之分，取决于业务上希望如何制定权限策略。
     * @param requestURI
     * @return
     */
    @Override
    public boolean needInterceptor(String requestURI) {
        List<Permission> ps = selectListPermission();
        for (Permission p : ps) {
            if (p.getPermission().equals(requestURI))
                return true;
        }
        return false;
    }

    /**
     * shiro基于URL的权限配置新增方法
     * 用来获取某个用户所拥有的权限地址集合
     * @param id
     * @return
     */
    @Override
    public Set<String> listPermissionURLs(Long id) {
        Set<String> result=new HashSet<>();
        Set<Role> roleSet = userService.selectUserRoleVO(id).getRoleSet();
        List<Permission> permissions=new ArrayList<>();

        for (Role item : roleSet) {
            Set<Permission> permissionList=new HashSet<>();
            Role role=roleService.selectRolePerVO(item.getId());
            for(Permission item1:role.getPermissionSet()){
                permissions.add(item1);
            }
        }

        for (Permission item : permissions) {
            result.add(item.getPermission());
        }
        return result;
    }
}
