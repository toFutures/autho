package com.lsdd.service;

import com.lsdd.entity.Role;
import com.lsdd.entity.User;

import java.util.List;

public interface RoleService {

    Role selectByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    int deleteByPrimaryKey(Long id);

    Role getByName(String roleName);

    List<Role> selectListRole();

    Role selectRolePerVO(Long id);

    int updateRolePer(Long id,Long[] ids);
}
