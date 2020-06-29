package com.lsdd.service.impl;


import com.lsdd.entity.Role;
import com.lsdd.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
public class RoleServiceImplTest {

    @Autowired
    RoleService roleService;

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void getByName() {
    }

    @Test
    public void selectListRole() {
        List<Role> roleList=roleService.selectListRole();
        for(Role role:roleList){
            System.out.println(role);
        }
    }
}
