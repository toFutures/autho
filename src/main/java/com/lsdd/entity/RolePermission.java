package com.lsdd.entity;

public class RolePermission {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_roles_permissions.id
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_roles_permissions.role_id
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_roles_permissions.permission_id
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    private Long permissionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_roles_permissions.id
     *
     * @return the value of sys_roles_permissions.id
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_roles_permissions.id
     *
     * @param id the value for sys_roles_permissions.id
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_roles_permissions.role_id
     *
     * @return the value of sys_roles_permissions.role_id
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_roles_permissions.role_id
     *
     * @param roleId the value for sys_roles_permissions.role_id
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_roles_permissions.permission_id
     *
     * @return the value of sys_roles_permissions.permission_id
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_roles_permissions.permission_id
     *
     * @param permissionId the value for sys_roles_permissions.permission_id
     *
     * @mbg.generated Thu Jun 25 20:21:33 CST 2020
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}