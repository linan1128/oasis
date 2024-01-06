package com.oasis.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long parentId;
    private List<T> children = new ArrayList<>();

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

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
