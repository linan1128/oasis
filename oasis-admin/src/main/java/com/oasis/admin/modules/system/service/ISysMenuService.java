package com.oasis.admin.modules.system.service;

import com.oasis.admin.modules.system.model.dto.SysMenuDTO;
import com.oasis.admin.modules.system.model.entity.system.SysMenu;

import java.util.List;

public interface ISysMenuService {
    public List<SysMenuDTO> getMenuList(SysMenu sysMenu);
}
