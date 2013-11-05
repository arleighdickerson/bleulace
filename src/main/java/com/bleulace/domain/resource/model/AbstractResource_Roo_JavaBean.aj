// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.domain.resource.model;

import com.bleulace.domain.crm.model.Account;
import com.bleulace.domain.management.model.Manager;
import com.bleulace.domain.resource.model.AbstractResource;
import java.util.List;
import org.joda.time.DateTime;

privileged aspect AbstractResource_Roo_JavaBean {
    
    public String AbstractResource.getId() {
        return this.id;
    }
    
    public void AbstractResource.setId(String id) {
        this.id = id;
    }
    
    public String AbstractResource.getTitle() {
        return this.title;
    }
    
    public void AbstractResource.setTitle(String title) {
        this.title = title;
    }
    
    public AbstractResource AbstractResource.getParent() {
        return this.parent;
    }
    
    public void AbstractResource.setParent(AbstractResource parent) {
        this.parent = parent;
    }
    
    public void AbstractResource.setChildren(List<AbstractResource> children) {
        this.children = children;
    }
    
    public List<Manager> AbstractResource.getManagers() {
        return this.managers;
    }
    
    public void AbstractResource.setManagers(List<Manager> managers) {
        this.managers = managers;
    }
    
    public DateTime AbstractResource.getCreatedDate() {
        return this.createdDate;
    }
    
    public void AbstractResource.setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }
    
    public DateTime AbstractResource.getLastModifiedDate() {
        return this.lastModifiedDate;
    }
    
    public void AbstractResource.setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
    public Account AbstractResource.getCreatedBy() {
        return this.createdBy;
    }
    
    public void AbstractResource.setCreatedBy(Account createdBy) {
        this.createdBy = createdBy;
    }
    
    public Account AbstractResource.getLastModifiedBy() {
        return this.lastModifiedBy;
    }
    
    public void AbstractResource.setLastModifiedBy(Account lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    
}
