package com.lsdd.service.impl;

import com.lsdd.dao.UserMapper;
import com.lsdd.dao.UserRoleMapper;
import com.lsdd.entity.User;
import com.lsdd.entity.UserRole;
import com.lsdd.entity.UserRoleVO;
import com.lsdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User getByName(String userName) {
        return userMapper.getByName(userName);
    }

    @Override
    public List<User> selectListUser() {
        return userMapper.selectListUser();
    }

    /**
     * 查询所有用户角色
     *
     * @return
     */
    public List<User> selectListUserRoleVO() {
        return userMapper.selectListUserRoleVO();
    }

    /**
     * 查询用户角色
     *
     * @param id
     * @return
     */
    @Override
    public User selectUserRoleVO(Long id) {
        return userMapper.selectUserRoleVO(id);
    }

    public int updateUserRole(Long id, Long[] ids) {
        List<UserRole> userRoleList = userRoleMapper.selectByUserId(id);
        for (UserRole item : userRoleList) {
            userRoleMapper.deleteByPrimaryKey(item.getId());
        }
        int result = 0;
        for (Long item : ids) {
            UserRole userRole = new UserRole();
            userRole.setUserId(id);
            userRole.setRoleId(item);
            result += userRoleMapper.insert(userRole);
        }
        return result;
    }
}
