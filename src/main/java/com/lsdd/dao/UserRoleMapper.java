package com.lsdd.dao;

import com.lsdd.entity.UserRole;
import org.springframework.stereotype.Component;

import java.util.List;


public interface UserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users_roles
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users_roles
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    int insert(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users_roles
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    int insertSelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users_roles
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    UserRole selectByPrimaryKey(Long id);

    List<UserRole> selectByUserId(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users_roles
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_users_roles
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    int updateByPrimaryKey(UserRole record);
}