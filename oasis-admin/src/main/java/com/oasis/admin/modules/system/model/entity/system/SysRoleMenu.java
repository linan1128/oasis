package com.oasis.admin.modules.system.model.entity.system;


import com.baomidou.mybatisplus.annotation.TableId;

public class SysRoleMenu {
    @TableId
    private Long id;
    private Long role_id;
    private Long menu_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Long menu_id) {
        this.menu_id = menu_id;
    }
}
