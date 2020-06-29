package com.lsdd.entity;

import java.util.List;

public class Identity {
    private String sessionId;
    private String loginIp;
    private User user;
    private List<Permission> permissionList;

    public String getSessionId() {
        return sessionId;
    }

    public Identity setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public Identity setLoginIp(String loginIp) {
        this.loginIp = loginIp;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Identity setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public Identity setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
        return this;
    }
}
