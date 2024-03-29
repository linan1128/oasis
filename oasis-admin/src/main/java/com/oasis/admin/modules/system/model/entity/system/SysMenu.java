package com.oasis.admin.modules.system.model.entity.system;


import com.baomidou.mybatisplus.annotation.TableId;
import com.oasis.admin.modules.system.model.dto.SysDeptDTO;
import com.oasis.admin.modules.system.model.dto.SysMenuDTO;
import com.oasis.admin.modules.system.model.entity.base.BaseEntity;

public class SysMenu extends BaseEntity {
    @TableId
    private Long id;
    private Long parentId;
    private String menuName;
    private Integer menuType;

    private String component;
    private String path;
    private String icon;
    private String permissions;
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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public SysMenuDTO toSysMenuDTO() {
        SysMenuDTO sysMenuDTO = new SysMenuDTO();
        sysMenuDTO.setId(this.getId());
        sysMenuDTO.setParentId(this.getParentId());
        sysMenuDTO.setMenuName(this.getMenuName());
        sysMenuDTO.setMenuType(this.getMenuType());
        sysMenuDTO.setComponent(this.getComponent());
        sysMenuDTO.setPath(this.getPath());
        sysMenuDTO.setIcon(this.getIcon());
        sysMenuDTO.setPermissions(this.getPermissions());
        sysMenuDTO.setSort(this.getSort());
        return sysMenuDTO;
    }

}
