package com.oasis.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oasis.model.dto.SysDeptDTO;
import com.oasis.model.entity.system.SysDept;
import com.oasis.model.mapper.SysDeptMapstruct;
import com.oasis.system.mapper.SysDeptMapper;
import com.oasis.system.service.ISysDeptService;
import com.oasis.common.utils.tree.TreeUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper,SysDept> implements ISysDeptService {

    @Override
    public List<SysDeptDTO> getDeptList(SysDept sysDept) {
        List<SysDept> list = this.list(new QueryWrapper<SysDept>().like("dept_name",sysDept.getDeptName()));

        List<SysDeptDTO> sysDeptDTOList = SysDeptMapstruct.INSTANCE.sysDeptListToSysDeptDTOList(list);

        return TreeUtils.build(sysDeptDTOList);

    }
}
