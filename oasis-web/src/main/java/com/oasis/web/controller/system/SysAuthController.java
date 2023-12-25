package com.oasis.web.controller.system;

import com.oasis.auth.model.SecurityUserDetails;
import com.oasis.auth.service.AuthService;
import com.oasis.model.ResponseResult;
import com.oasis.model.entity.system.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class SysAuthController {
    @Resource
    private AuthenticationManager authenticationManager;



    @Autowired
    private AuthService authService;

    @RequestMapping("/login")
    public ResponseResult login(){
        SysUser user = new SysUser();
        user.setUsername("admin");
        user.setPassword("admin123");
        String token = this.authService.login(user);
        Map<String,String> map=new HashMap<>();
        map.put("token",token);
        return new ResponseResult(200,"登陆成功",map);
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }
}
