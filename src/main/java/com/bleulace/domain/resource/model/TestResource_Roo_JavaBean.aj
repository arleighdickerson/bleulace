// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.domain.resource.model;

import java.util.List;

privileged aspect TestResource_Roo_JavaBean {
    
    public TestResource TestResource.getParent() {
        return this.parent;
    }
    
    public void TestResource.setParent(TestResource parent) {
        this.parent = parent;
    }
    
    public List<TestResource> TestResource.getChildren() {
        return this.children;
    }
    
    public void TestResource.setChildren(List<TestResource> children) {
        this.children = children;
    }
    
}
