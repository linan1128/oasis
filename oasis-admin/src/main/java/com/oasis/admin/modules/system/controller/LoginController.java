package com.oasis.admin.modules.system.controller;

import com.oasis.admin.common.utils.Result;
import com.oasis.admin.modules.system.model.dto.LoginUserDTO;
import com.oasis.admin.modules.system.service.LoginService;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Result login(@RequestBody LoginUserDTO loginUserDto){
        String token = this.loginService.login(loginUserDto.getUsername(), loginUserDto.getPassword());
        Map<String,String> map=new HashMap<>();
        map.put("token",token);
        return Result.ok(map);
    }

    @RequestMapping("/logout")
    public Result logout(){
        return Result.ok();
    }
}
