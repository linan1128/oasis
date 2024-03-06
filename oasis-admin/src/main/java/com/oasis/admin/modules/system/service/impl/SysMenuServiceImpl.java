package com.oasis.admin.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oasis.admin.common.utils.TreeUtils;
import com.oasis.admin.modules.system.mapper.SysMenuMapper;
import com.oasis.admin.modules.system.model.dto.SysDeptDTO;
import com.oasis.admin.modules.system.model.dto.SysMenuDTO;
import com.oasis.admin.modules.system.model.entity.system.SysDept;
import com.oasis.admin.modules.system.model.entity.system.SysMenu;
import com.oasis.admin.modules.system.service.ISysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List<SysMenuDTO> getMenuList(SysMenu sysMenu) {

        List<SysMenu> list = this.list();
        List<SysMenuDTO> sysMenuDTOList = list.stream().map(SysMenu::toSysMenuDTO).collect(Collectors.toList());

        return TreeUtils.build(sysMenuDTOList);
    }
}
