package com.oasis.admin.modules.system.controller;

import com.oasis.admin.common.utils.Result;
import com.oasis.admin.modules.system.model.entity.system.SysUser;
import com.oasis.admin.modules.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;
    @RequestMapping("/login")
    public Result login(){
        SysUser user = new SysUser();
        user.setUsername("admin");
        user.setPassword("admin123");
        String token = this.loginService.login(user);
        Map<String,String> map=new HashMap<>();
        map.put("token",token);
        return Result.ok(map);
    }

    @RequestMapping("/logout")
    public Result logout(){
        return Result.ok();
    }
}
