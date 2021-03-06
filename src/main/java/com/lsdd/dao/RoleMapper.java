package com.lsdd.dao;

import com.lsdd.entity.Role;

import java.util.List;

public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    Role selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    int updateByPrimaryKey(Role record);

    Role getByName(String roleName);

    List<Role> selectListRole();

    Role selectRolePerVO(Long id);
}