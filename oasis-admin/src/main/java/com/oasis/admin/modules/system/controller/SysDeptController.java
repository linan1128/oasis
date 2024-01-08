package com.oasis.admin.modules.system.controller;

import com.oasis.admin.common.utils.Result;
import com.oasis.admin.modules.system.model.entity.system.SysDept;
import com.oasis.admin.modules.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class SysDeptController {
    @Autowired
    private ISysDeptService deptService;
    @GetMapping("/list")
    public Result getUserList(SysDept sysDept){
        return Result.ok(this.deptService.getDeptList(sysDept));
    }

    @PostMapping("/add")
    public Result add(SysDept sysDept){

        return null;
    }

    @PostMapping("/edit")
    public Result edit(SysDept sysDept){

        return null;
    }
}
