package com.lsdd.service.impl;

import com.lsdd.dao.RoleMapper;
import com.lsdd.dao.RolePermissionMapper;
import com.lsdd.entity.Role;
import com.lsdd.entity.RolePermission;
import com.lsdd.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl  implements RoleService {

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Override
    public Role selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {

        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Role getByName(String roleName) {
        return roleMapper.getByName(roleName);
    }

    @Override
    public List<Role> selectListRole() {
        return roleMapper.selectListRole();
    }

    @Override
    public Role selectRolePerVO(Long id) {
        return roleMapper.selectRolePerVO(id);
    }

    @Override
    public int updateRolePer(Long id, Long[] ids) {
        List<RolePermission> rolePermissionList = rolePermissionMapper.selectByRoleId(id);
        for (RolePermission item : rolePermissionList) {
            rolePermissionMapper.deleteByPrimaryKey(item.getId());
        }
        int result = 0;
        for (Long item : ids) {
            RolePermission rolePermission=new RolePermission();
            rolePermission.setRoleId(id);
            rolePermission.setPermissionId(item);
            result += rolePermissionMapper.insert(rolePermission);
        }
        return result;
    }
}
