package com.lsdd.entity;

import java.util.List;

public class UserRoleVO {
    private User user;
    private List<Role> roleList;

    public User getUser() {
        return user;
    }

    public UserRoleVO setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public UserRoleVO setRoleList(List<Role> roleList) {
        this.roleList = roleList;
        return this;
    }
}
