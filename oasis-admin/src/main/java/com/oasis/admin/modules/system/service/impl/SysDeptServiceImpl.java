package com.oasis.admin.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oasis.admin.common.utils.TreeUtils;
import com.oasis.admin.modules.system.mapper.SysDeptMapper;
import com.oasis.admin.modules.system.model.dto.SysDeptDTO;
import com.oasis.admin.modules.system.model.entity.system.SysDept;
import com.oasis.admin.modules.system.service.ISysDeptService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper,SysDept> implements ISysDeptService {

    @Override
    public List<SysDeptDTO> getDeptList(SysDept sysDept) {
        List<SysDept> list = this.list(new QueryWrapper<SysDept>().like("dept_name",sysDept.getDeptName()));

        List<SysDeptDTO> sysDeptDTOList = list.stream().map(SysDept::toSysDeptDTO).collect(Collectors.toList());

        return TreeUtils.build(sysDeptDTOList);

    }

    @Override
    public List<SysDeptDTO> getDeptTree() {
        List<SysDept> list = this.list();

        List<SysDeptDTO> sysDeptDTOList = list.stream().map(SysDept::toSysDeptDTO).collect(Collectors.toList());

        return TreeUtils.build(sysDeptDTOList);
    }
}
