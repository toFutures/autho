package com.lsdd.controller;

import com.lsdd.entity.Permission;
import com.lsdd.entity.Role;
import com.lsdd.entity.User;
import com.lsdd.entity.UserRole;
import com.lsdd.service.PermissionService;
import com.lsdd.service.RoleService;
import com.lsdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UIController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    @RequestMapping("/menu")
    public String menu() {
        return "admin/menu";
    }

    @RequestMapping("/listUser")
    public String listUser(Model model) {
        List<User> users = userService.selectListUser();
        model.addAttribute("users", users);
        return "admin/listUser";
    }

    @RequestMapping("/addUser")
    public String addUser() {
        return "admin/addUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(Long id, Model model) {
        User user = userService.selectByPrimaryKey(id);
        model.addAttribute("user", user);
        return "admin/updateUser";
    }

    @RequestMapping("/listRole")
    public String listRole(Model model) {
        List<Role> roleList = roleService.selectListRole();
        model.addAttribute("roleList", roleList);
        return "admin/role/listRole";
    }

    @RequestMapping("/addRole")
    public String addRole(Model model) {
        List<Role> roleList = roleService.selectListRole();
        model.addAttribute("roleList", roleList);
        return "admin/role/addRole";
    }

    @RequestMapping("/updateRole")
    public String updateRole(Long id, Model model) {
        Role role = roleService.selectByPrimaryKey(id);
        List<Role> roleList = roleService.selectListRole();
        model.addAttribute("roleList", roleList);
        model.addAttribute("role", role);
        return "admin/role/updateRole";
    }

    @RequestMapping("/listPermission")
    public String listPermission(Model model) {
        List<Permission> permissionList = permissionService.selectListPermission();
        model.addAttribute("permissionList", permissionList);
        return "admin/permission/listPermission";
    }

    @RequestMapping("/addPermission")
    public String addPermission(Model model) {
        List<Permission> permissionList = permissionService.selectListPermission();
        model.addAttribute("permissionList", permissionList);
        return "admin/permission/addPermission";
    }

    @RequestMapping("/updatePermission")
    public String updatePermission(Long id, Model model) {
        Permission permission = permissionService.selectByPrimaryKey(id);
        List<Permission> permissionList = permissionService.selectListPermission();
        model.addAttribute("permissionList", permissionList);
        model.addAttribute("permission", permission);
        return "admin/permission/updatePermission";
    }

    @RequestMapping("/roleperlist")
    public String roleperlist(Model model) {
        List<Role> roleList = roleService.selectListRole();
        model.addAttribute("roleList", roleList);
        return "admin/roleper/list";
    }

    @RequestMapping("/roleperupdate")
    public String roleperupdate(Model model, Long id) {
        Role rolePerVO = roleService.selectRolePerVO(id);
        List<Permission> permissionList = permissionService.selectListPermission();
        List<Permission> permissionListClone = new ArrayList<>();
        for (Permission item : permissionList) {
            permissionListClone.add(item);
        }
        for (Permission permission : rolePerVO.getPermissionSet()) {
            for (Permission item : permissionListClone) {
                if (item.getId() == permission.getId()) {
                    permissionList.remove(item);
                }
            }
        }
        model.addAttribute("rolePerVO", rolePerVO);
        model.addAttribute("permissionList", permissionList);
        return "admin/roleper/update";
    }

    @RequestMapping("/roleperadd")
    public String roleperadd(Model model, Long id) {
        return "admin/roleper/add";
    }

    @RequestMapping("/userrolelist")
    public String userrolelist(Model model) {
        List<User> userRoleList = userService.selectListUserRoleVO();
        model.addAttribute("userRoleList", userRoleList);
        return "admin/userrole/listm";
    }

    @RequestMapping("/userroleadd")
    public String userroleadd(Model model) {
        return "admin/userrole/add";
    }

    @RequestMapping("/userroleupdate")
    public String userroleupdate(Model model, Long id) {
        User userRoleVO = userService.selectUserRoleVO(id);
        List<Role> roleList = roleService.selectListRole();
        List<Role> roleListClone = new ArrayList<>();
        for (Role item : roleList) {
            roleListClone.add(item);
        }
        for (Role role : userRoleVO.getRoleSet()) {
            for (Role item : roleListClone) {
                if (item.getId() == role.getId()) {
                    roleList.remove(item);
                }
            }
        }
        model.addAttribute("userRoleVO", userRoleVO);
        model.addAttribute("roleList", roleList);
        return "admin/userrole/update";
    }

    @RequestMapping("/success")
    public String success(Model model) {
        return "status/success";
    }

    @RequestMapping("/404")
    public String fail(Model model) {
        return "status/404";
    }
}
