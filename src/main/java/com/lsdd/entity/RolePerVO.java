package com.lsdd.entity;

import java.util.List;

public class RolePerVO {

    private Role role;
    private List<Permission> permissionList;

    public Role getRole() {
        return role;
    }

    public RolePerVO setRole(Role role) {
        this.role = role;
        return this;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public RolePerVO setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
        return this;
    }
}
