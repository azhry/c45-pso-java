/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Map;

/**
 *
 * @author Azhary Arliansyah
 */
public class Node {
    
    enum Type {
        ROOT, BRANCH, LEAF
    }
    
    private String attribute;
    private int label;
    private Type nodeType;
    private Map<Integer, Node> childNodes;
    
    public Node(String attribute, Type nodeType) {
        this.attribute = attribute;
        this.childNodes = null;
        this.nodeType = nodeType;
    }
    
    public Node(int label) {
        this.label = label;
        this.childNodes = null;
        this.nodeType = Type.ROOT;
    }
    
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    
    public void setChilds(Map<Integer, Node> childs) {
        this.childNodes = childs;
    }
    
    public Node getChild(int value) {
        return this.childNodes.get(value);
    }
    
    public Map<Integer, Node> getChilds() {
        return this.childNodes;
    }
}
