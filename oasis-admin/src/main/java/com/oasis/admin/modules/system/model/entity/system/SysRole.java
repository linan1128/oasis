package com.oasis.admin.modules.system.model.entity.system;

import com.baomidou.mybatisplus.annotation.TableId;
import com.oasis.admin.modules.system.model.entity.base.BaseEntity;

public class SysRole extends BaseEntity {
    @TableId
    private Long role_id;
    private String role_code;
    private String role_name;

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
