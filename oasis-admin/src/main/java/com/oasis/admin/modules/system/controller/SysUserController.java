package com.oasis.admin.modules.system.controller;


import com.oasis.admin.common.utils.Result;
import com.oasis.admin.modules.system.model.entity.system.SysUser;
import com.oasis.admin.modules.system.service.ISysDeptService;
import com.oasis.admin.modules.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/user")
public class SysUserController {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysDeptService deptService;
    @GetMapping("/list")
    public Result getUserList(SysUser sysUser){
        return Result.ok(this.userService.getUserList());
    }

    @GetMapping("/deptTree")
    public Result getDeptTree(){
        return Result.ok(this.deptService.getDeptTree());
    }

    @PostMapping("/add")
    public Result add(SysUser sysUser){

        return null;
    }

    @PostMapping("/edit")
    public Result edit(SysUser sysUser){

        return null;
    }
}
