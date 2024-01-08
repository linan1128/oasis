package com.oasis.admin.modules.system.service.impl;

import com.oasis.admin.modules.system.mapper.SysUserMapper;
import com.oasis.admin.modules.system.model.entity.system.SysUser;
import com.oasis.admin.modules.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    private SysUserMapper userMapper;
    public List<SysUser> getUserList(){
        return this.userMapper.selectList(null);
    }
}
