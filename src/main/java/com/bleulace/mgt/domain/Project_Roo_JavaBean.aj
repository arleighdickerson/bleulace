// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.mgt.domain;

import com.bleulace.mgt.domain.Bundle;
import com.bleulace.mgt.domain.Project;
import com.bleulace.mgt.domain.ProjectManager;
import java.util.List;

privileged aspect Project_Roo_JavaBean {
    
    public String Project.getTitle() {
        return this.title;
    }
    
    public void Project.setTitle(String title) {
        this.title = title;
    }
    
    public List<ProjectManager> Project.getMgrList() {
        return this.mgrList;
    }
    
    public void Project.setMgrList(List<ProjectManager> mgrList) {
        this.mgrList = mgrList;
    }
    
    public List<Bundle> Project.getBundles() {
        return this.bundles;
    }
    
    public void Project.setBundles(List<Bundle> bundles) {
        this.bundles = bundles;
    }
    
}
