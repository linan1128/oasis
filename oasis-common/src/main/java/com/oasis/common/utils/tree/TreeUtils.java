package com.oasis.common.utils.tree;

import com.oasis.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TreeUtils {
    public static <T extends TreeNode<T>> List<T> build(List<T> treeNodes) {
        List<T> result = new ArrayList<>();
        Map<Long, T> nodeMap = new LinkedHashMap<>(treeNodes.size());
        for(T treeNode : treeNodes){
            nodeMap.put(treeNode.getId(), treeNode);
        }
        for(T node : nodeMap.values()) {
            T parent = nodeMap.get(node.getParentId());
            if(parent != null && !(node.getId().equals(parent.getId()))){
                parent.getChildren().add(node);
                continue;
            }
            result.add(node);
        }
        return result;
    }

    public static <T extends TreeNode<T>> List<T> build(List<T> treeNodes, Long pid) {
        List<T> treeList = new ArrayList<>();
        for(T treeNode : treeNodes) {
            if (pid.equals(treeNode.getParentId())) {
                treeList.add(findChildren(treeNodes, treeNode));
            }
        }
        return treeList;
    }
    private static <T extends TreeNode<T>> T findChildren(List<T> treeNodes, T rootNode) {
        for(T treeNode : treeNodes) {
            if(rootNode.getId().equals(treeNode.getParentId())) {
                rootNode.getChildren().add(findChildren(treeNodes, treeNode));
            }
        }
        return rootNode;
    }
}
