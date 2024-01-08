package com.oasis.admin.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oasis.admin.modules.system.model.dto.SysDeptDTO;
import com.oasis.admin.modules.system.model.entity.system.SysDept;


import java.util.List;

public interface ISysDeptService extends IService<SysDept> {
    public List<SysDeptDTO> getDeptList(SysDept sysDept);

    public List<SysDeptDTO> getDeptTree();
}
