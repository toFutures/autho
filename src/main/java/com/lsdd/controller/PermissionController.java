package com.lsdd.controller;

import com.lsdd.entity.Permission;
import com.lsdd.entity.ResultCode;
import com.lsdd.entity.ResultVO;
import com.lsdd.entity.Role;
import com.lsdd.service.PermissionService;
import com.lsdd.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @RequestMapping("/listPermission")
    public String list(Model model){
        List<Permission> permissionList=permissionService.selectListPermission();
        model.addAttribute("permissionList",permissionList);
        return "admin/listUser";
    }

    @RequestMapping("/permission")
    public String get(Model model,String permissionName){
        Permission permission=permissionService.getByName(permissionName);
        model.addAttribute("permission",permission);
        return "admin/listUser";
    }

    @RequestMapping("/addPermission")
    @ResponseBody
    public ResultVO<String> add(Model model, Permission permission) {
        if(permission==null){
            return new ResultVO<>(ResultCode.FAILED,"添加失败");
        }
        if(permission.getPermission()==null)
        {
            return new ResultVO<>(ResultCode.FAILED,"角色名不能为空");
        }
        if(permission.getAvailable()==null){
            permission.setAvailable(false);  //是否锁定 否
        }
        int result=permissionService.insert(permission);
        return new ResultVO<>(result + "记录添加成功！");
    }

    @RequestMapping("/updatePermission")
    @ResponseBody
    public ResultVO<String> update(Permission permission) {
        if(permission==null){
            return new ResultVO<>(ResultCode.FAILED,"修改失败");
        }
        if(permission.getPermission()==null)
        {
            return new ResultVO<>(ResultCode.FAILED,"权限名不能为空");
        }
        if(permission.getAvailable()==null){
            permission.setAvailable(false);
        }
        int result = permissionService.updateByPrimaryKey(permission);

        return new ResultVO<>(result + "记录修改成功！");
    }

    @RequestMapping("/deletePermission")
    @ResponseBody
    public ResultVO<String> delete(Long id) {
        if (id == null) {
            return new ResultVO<>(ResultCode.ERROR, "请选择删除记录");
        }
        int result = permissionService.deleteByPrimaryKey(id);
        return new ResultVO<>(result + "记录删除成功！");
    }
}
