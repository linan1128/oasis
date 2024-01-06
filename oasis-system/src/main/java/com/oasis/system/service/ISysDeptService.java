package com.oasis.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oasis.model.dto.SysDeptDTO;
import com.oasis.model.entity.system.SysDept;

import java.util.List;

public interface ISysDeptService extends IService<SysDept> {
    public List<SysDeptDTO> getDeptList(SysDept sysDept);
}
