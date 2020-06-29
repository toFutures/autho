package com.lsdd.service;

import com.lsdd.entity.User;
import com.lsdd.entity.UserRoleVO;

import java.util.List;

public interface UserService {

    User selectByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteByPrimaryKey(Long id);

    User getByName(String userName);

    List<User> selectListUser();

    List<User> selectListUserRoleVO();

    User selectUserRoleVO(Long id);

    int updateUserRole(Long id,Long[] ids);
}
