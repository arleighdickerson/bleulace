// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.mgt.domain;

import com.bleulace.crm.domain.Account;

privileged aspect JPAManagementPermission_Roo_JavaBean {
    
    public Account JPAManagementPermission.getAccount() {
        return this.account;
    }
    
    public Project JPAManagementPermission.getProject() {
        return this.project;
    }
    
    public ManagementAssignment JPAManagementPermission.getAssignment() {
        return this.assignment;
    }
    
}
