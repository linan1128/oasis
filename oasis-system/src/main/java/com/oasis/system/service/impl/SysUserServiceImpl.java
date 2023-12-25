package com.oasis.system.service.impl;

import com.oasis.model.entity.system.SysUser;
import com.oasis.system.mapper.SysUserMapper;
import com.oasis.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper userMapper;
    public List<SysUser> getUserList(){
        return this.userMapper.selectList(null);
    }
}