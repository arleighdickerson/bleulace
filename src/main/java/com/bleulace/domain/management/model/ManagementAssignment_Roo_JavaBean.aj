// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.domain.management.model;

import com.bleulace.domain.crm.model.Account;
import com.bleulace.domain.management.model.ManagementAssignment;
import com.bleulace.domain.management.model.ManagementLevel;
import com.bleulace.domain.resource.model.AbstractResource;

privileged aspect ManagementAssignment_Roo_JavaBean {
    
    public Account ManagementAssignment.getAccount() {
        return this.account;
    }
    
    public AbstractResource ManagementAssignment.getResource() {
        return this.resource;
    }
    
    public ManagementLevel ManagementAssignment.getRole() {
        return this.role;
    }
    
}