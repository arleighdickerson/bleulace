// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.domain.crm.model;

import com.bleulace.domain.crm.model.Account;
import com.bleulace.domain.crm.model.AccountGroup;
import java.util.Set;

privileged aspect AccountGroup_Roo_JavaBean {
    
    public String AccountGroup.getTitle() {
        return this.title;
    }
    
    public void AccountGroup.setTitle(String title) {
        this.title = title;
    }
    
    public Set<Account> AccountGroup.getMembers() {
        return this.members;
    }
    
    public void AccountGroup.setMembers(Set<Account> members) {
        this.members = members;
    }
    
}