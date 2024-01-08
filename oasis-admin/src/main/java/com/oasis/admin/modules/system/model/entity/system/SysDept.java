package com.oasis.admin.modules.system.model.entity.system;


import com.oasis.admin.modules.system.model.dto.SysDeptDTO;
import com.oasis.admin.modules.system.model.entity.base.BaseEntity;

public class SysDept extends BaseEntity {
    private Long id;
    private Long parentId;
    private String parentIds;
    private String deptName;
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public SysDeptDTO toSysDeptDTO() {
        SysDeptDTO sysDeptDTO = new SysDeptDTO();
        sysDeptDTO.setId( this.getId() );
        sysDeptDTO.setParentId( this.getParentId() );
        sysDeptDTO.setDeptName( this.getDeptName() );
        sysDeptDTO.setSort( this.getSort() );
        return sysDeptDTO;
    }
}
