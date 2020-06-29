package com.lsdd.controller;

import com.lsdd.dao.RoleMapper;
import com.lsdd.entity.ResultCode;
import com.lsdd.entity.ResultVO;
import com.lsdd.entity.Role;
import com.lsdd.entity.User;
import com.lsdd.service.RoleService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/listRole")
    public String listRole(Model model){
        List<Role> roleList=roleService.selectListRole();
        for(Role role:roleList){
            if(role.getPid()!=null){
                roleService.selectByPrimaryKey(role.getPid());
            }
        }
        model.addAttribute("roleList",roleList);
        return "admin/listUser";
    }

    @RequestMapping("/role")
    public String getRole(Model model,String roleName){
        Role role=roleService.getByName(roleName);
        model.addAttribute("role",role);
        return "admin/listUser";
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public ResultVO<String> add(Model model, Role role) {
        if(role==null){
            return new ResultVO<>(ResultCode.FAILED,"添加失败");
        }
        if(role.getRole()==null)
        {
            return new ResultVO<>(ResultCode.FAILED,"角色名不能为空");
        }
        if(role.getAvailable()==null){
            role.setAvailable(false);  //是否锁定 否
        }
        int result=roleService.insert(role);
        return new ResultVO<>(result + "记录添加成功！");
    }

    @RequestMapping("/updateRole")
    @ResponseBody
    public ResultVO<String> update(Role role) {
        if(role==null){
            return new ResultVO<>(ResultCode.FAILED,"修改失败");
        }
        if(role.getRole()==null)
        {
            return new ResultVO<>(ResultCode.FAILED,"角色名不能为空");
        }
        if(role.getAvailable()==null){
            role.setAvailable(false);
        }
        int result = roleService.updateByPrimaryKey(role);

        return new ResultVO<>(result + "记录修改成功！");
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public ResultVO<String> delete(Long id) {
        if (id == null) {
            return new ResultVO<>(ResultCode.ERROR, "请选择删除记录");
        }
        int result = roleService.deleteByPrimaryKey(id);
        return new ResultVO<>(result + "记录删除成功！");
    }

    @RequestMapping("/updateRolePer")
    @ResponseBody
    public ResultVO<String> updateRolePer(Long id,Long[] perId){
        return new ResultVO<>(roleService.updateRolePer(id,perId) + "记录已更改");
    }
}
