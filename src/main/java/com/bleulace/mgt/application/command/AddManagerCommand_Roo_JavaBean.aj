// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.mgt.application.command;

import com.bleulace.mgt.application.command.AddManagerCommand;
import com.bleulace.mgt.domain.ManagementLevel;

privileged aspect AddManagerCommand_Roo_JavaBean {
    
    public String AddManagerCommand.getId() {
        return this.id;
    }
    
    public String AddManagerCommand.getAccountId() {
        return this.accountId;
    }
    
    public void AddManagerCommand.setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    public ManagementLevel AddManagerCommand.getLevel() {
        return this.level;
    }
    
    public void AddManagerCommand.setLevel(ManagementLevel level) {
        this.level = level;
    }
    
}