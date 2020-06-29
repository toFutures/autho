package com.lsdd.service;

import com.lsdd.entity.Permission;
import com.lsdd.entity.Role;
import com.lsdd.entity.User;

import java.util.List;
import java.util.Set;

public interface PermissionService {

    Permission selectByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    int deleteByPrimaryKey(Long id);

    Permission getByName(String permissionName);

    List<Permission> selectListPermission();

    /**
     * shiro基于URL的权限配置新增方法
     * @param requestURI
     * @return
     */
    boolean needInterceptor(String requestURI);

    /**
     * shiro基于URL的权限配置新增方法
     * @param id
     * @return
     */
    Set<String> listPermissionURLs(Long id);
}
