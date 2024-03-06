package com.oasis.admin.modules.system.controller;

import com.oasis.admin.common.utils.Result;
import com.oasis.admin.modules.system.mapper.SysMenuMapper;
import com.oasis.admin.modules.system.model.entity.system.SysDept;
import com.oasis.admin.modules.system.model.entity.system.SysMenu;
import com.oasis.admin.modules.system.service.ISysDeptService;
import com.oasis.admin.modules.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class SysMenuController {
    @Autowired
    private ISysMenuService menuService;
    @GetMapping("/list")
    public Result getMenuList(SysMenu sysMenu){
        return Result.ok(this.menuService.getMenuList(sysMenu));
    }

    @PostMapping("/add")
    public Result add(SysMenu sysMenu){

        return null;
    }

    @PostMapping("/edit")
    public Result edit(SysMenu sysMenu){

        return null;
    }
}
