package com.oasis.web.controller.system;

import com.oasis.model.ResponseResult;
import com.oasis.model.entity.system.SysUser;
import com.oasis.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private SysUserService userService;
    @RequestMapping("/list")
    public ResponseResult getUserList(){
        return new ResponseResult(200,this.userService.getUserList());
    }
}
