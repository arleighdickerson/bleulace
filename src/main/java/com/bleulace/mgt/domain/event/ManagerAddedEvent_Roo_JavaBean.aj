// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.mgt.domain.event;

import com.bleulace.mgt.domain.ManagementLevel;

privileged aspect ManagerAddedEvent_Roo_JavaBean {
    
    public String ManagerAddedEvent.getAccountId() {
        return this.accountId;
    }
    
    public void ManagerAddedEvent.setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    public String ManagerAddedEvent.getTargetId() {
        return this.targetId;
    }
    
    public void ManagerAddedEvent.setTargetId(String targetId) {
        this.targetId = targetId;
    }
    
    public ManagementLevel ManagerAddedEvent.getLevel() {
        return this.level;
    }
    
    public void ManagerAddedEvent.setLevel(ManagementLevel level) {
        this.level = level;
    }
    
}
