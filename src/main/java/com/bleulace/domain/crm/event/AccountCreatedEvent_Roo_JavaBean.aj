// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.domain.crm.event;

import com.bleulace.domain.crm.model.ContactInformation;

privileged aspect AccountCreatedEvent_Roo_JavaBean {
    
    public String AccountCreatedEvent.getUsername() {
        return this.username;
    }
    
    public String AccountCreatedEvent.getPassword() {
        return this.password;
    }
    
    public ContactInformation AccountCreatedEvent.getContactInformation() {
        return this.contactInformation;
    }
    
}
