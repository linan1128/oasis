package com.oasis.admin.controller.system;

import com.oasis.model.ResponseResult;
import com.oasis.model.entity.system.SysDept;
import com.oasis.system.service.ISysDeptService;
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
    public ResponseResult getUserList(SysDept sysDept){
        return new ResponseResult(200,this.deptService.getDeptList(sysDept));
    }

    @PostMapping("/add")
    public ResponseResult add(SysDept sysDept){

        return null;
    }

    @PostMapping("/edit")
    public ResponseResult edit(SysDept sysDept){

        return null;
    }
}
