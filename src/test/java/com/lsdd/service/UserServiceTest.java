package com.lsdd.service;

import com.lsdd.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Component
public class UserServiceTest {
    @Autowired(required = false)
    UserService userService;

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
    public void selectListUser() {
        userService.selectListUser();
    }

    @Test
    public void selectListUserRoleVO() {
    }

    @Test
    public void selectUserRoleVO() {
    }

    @Test
    public void updateUserRole() {
    }
}