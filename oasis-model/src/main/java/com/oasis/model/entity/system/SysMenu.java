package com.oasis.model.entity.system;

import com.oasis.model.entity.base.BaseEntity;

public class SysMenu extends BaseEntity {
    private Long menu_id;
    private String menu_name;

    public Long getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Long menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }
}
