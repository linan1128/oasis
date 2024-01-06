package com.oasis.model.mapper;

import com.oasis.model.dto.SysDeptDTO;
import com.oasis.model.entity.system.SysDept;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysDeptMapstruct {
    SysDeptMapstruct INSTANCE = Mappers.getMapper(SysDeptMapstruct.class);
    SysDeptDTO sysDeptToSysDeptDTO(SysDept sysDept);
    List<SysDeptDTO> sysDeptListToSysDeptDTOList(List<SysDept> sysDeptList);
}
