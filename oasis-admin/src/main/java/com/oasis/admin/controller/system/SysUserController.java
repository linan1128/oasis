package com.oasis.admin.controller.system;

import com.oasis.model.ResponseResult;
import com.oasis.model.entity.system.SysUser;
import com.oasis.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private ISysUserService userService;
    @GetMapping("/list")
    public ResponseResult getUserList(){
        return new ResponseResult(200,this.userService.getUserList());
    }

    @PostMapping("/add")
    public ResponseResult add(SysUser sysUser){

        return null;
    }

    @PostMapping("/edit")
    public ResponseResult edit(SysUser sysUser){

        return null;
    }
}
