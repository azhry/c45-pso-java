/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Azhary Arliansyah
 */
public class Node {
    
    enum Type {
        ROOT, BRANCH, LEAF
    }
    
    private String attribute;
    private Integer label;
    private Type nodeType;
    private Map<Integer, Node> childNodes;
    private Set<String> parentExcludedAttributes;
    
    public Node(String attribute, Type nodeType) {
        this.attribute = attribute;
        this.childNodes = new HashMap<>();
        this.nodeType = nodeType;
        this.label = null;
    }
    
    public Node(Integer label) {
        this.label = label;
        this.childNodes = new HashMap<>();
        this.nodeType = Type.LEAF;
    }
    
    public Node() {
        this.childNodes = new HashMap<>();
        this.label = null;
    }
    
    public void setExcludedAttributes(Set<String> attrs) {
        this.parentExcludedAttributes = attrs;
    }
    
    public Set<String> getExcludedAttributes() {
        return this.parentExcludedAttributes;
    }
    
    public void setLabel(Integer label) {
        this.label = label;
    }
    
    public Integer getLabel() {
        return this.label;
    }
    
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    
    public String getAttribute() {
        return this.attribute;
    }
    
    public void setChilds(Map<Integer, Node> childs) {
        this.childNodes = childs;
    }
    
    public void addChild(int branch, Node child) {
        this.childNodes.put(branch, child);
    }
    
    public Node getChild(int value) {
        return this.childNodes.get(value);
    }
    
    public Map<Integer, Node> getChilds() {
        return this.childNodes;
    }
    
    public void setType(Type t) {
        this.nodeType = t;
    }
    
    public Type getType() {
        return this.nodeType;
    }
}
