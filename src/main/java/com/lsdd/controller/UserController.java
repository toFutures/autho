package com.lsdd.controller;

import com.lsdd.entity.Identity;
import com.lsdd.entity.ResultCode;
import com.lsdd.entity.ResultVO;
import com.lsdd.entity.User;
import com.lsdd.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public ResultVO<String> login(Model model, @Valid User user, HttpServletResponse response, HttpSession session) {
        //获取Subject主体
        Subject subject = SecurityUtils.getSubject();
        //String password=user.getPassword();
        //封装用户数据
        System.out.println(user.getUsername() + " + " + user.getPassword());
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(user.getUsername(), user.getPassword());
        subject.login(usernamePasswordToken);
        /*try {
            subject.login(usernamePasswordToken);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("用户名或密码错误");
            throw e;
            //return new ResultVO<>(ResultCode.FAILED, e.getMessage());
        }*/
        Cookie cookie = new Cookie("userCookies", user.getUsername() + "." + user.getPassword());
        cookie.setPath("/");
        cookie.setMaxAge(10*60);
        response.addCookie(cookie);

        Identity identity = new Identity();
        String sessionId = getSessionId(user.getUsername(), identity.getLoginIp());
        identity.setSessionId(sessionId);
        identity.setUser(user);
        identity.setLoginIp("0.0.0.00");
        session.setAttribute("loginUser",userService.getByName(user.getUsername()));
        return new ResultVO<>(ResultCode.SUCCESS, "status/success");
    }

    @RequestMapping("/regist")
    public ModelAndView regist() {
        ModelAndView modelAndView = new ModelAndView("regist");
        return modelAndView;
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public ResultVO<User> add(Model model, String username, String password) {
        //生成盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";
        //加密密码
        String encodedPassword = new SimpleHash(algorithmName, password, salt, times).toString();

        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setSalt(salt);
        //false表示不锁定 true表示锁定
        user.setLocked(false);//是否锁定字段类型为tinyint(1)，设置这种类型，数据库中实际存储的是int类型数据，一般是0和1，在使用Mybatis取这个字段的数据时，Mybatis会自动将tinyint(1)字段值为0的转换成false，将字段值为1以上的转换为true。
        System.out.println(user);
        userService.insert(user);
        return new ResultVO<>(user);
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public ResultVO<String> update(User user) {
        //生成盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";
        //加密密码
        String encodedPassword = new SimpleHash(algorithmName, user.getPassword(), salt, times).toString();
        user.setPassword(encodedPassword);
        user.setSalt(salt);
        int result = userService.updateByPrimaryKeySelective(user);

        return new ResultVO<>(String.valueOf(result));
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public ResultVO<String> delete(Long id) {
        if (id == null) {
            return new ResultVO<>(ResultCode.ERROR, "请选择删除记录");
        }
        int result = userService.deleteByPrimaryKey(id);
        return new ResultVO<>(String.valueOf(result));
    }

    @RequestMapping("/updateUserRole")
    @ResponseBody
    public ResultVO<String> updateUserRole(Long id,Long[] roleId) {
        return new ResultVO<>(userService.updateUserRole(id,roleId) + "记录已更改");

    }

    private String getSessionId(String userName, String ip) {
        String str = userName + "_" + System.currentTimeMillis() + "_" + ip;
        try
        {
            return str;
        }
        catch (Exception e) {}
        return "生成token错误";
    }
}
