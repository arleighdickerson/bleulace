// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.domain.management.model;

import java.util.Map;

import com.bleulace.domain.crm.model.Account;
import com.bleulace.jpa.DateWindow;

privileged aspect Event_Roo_JavaBean {
    
    public DateWindow Event.getWindow() {
        return this.window;
    }
    
    public void Event.setWindow(DateWindow window) {
        this.window = window;
    }
    
    public Map<Account, EventInvitee> Event.getInvitees() {
        return this.invitees;
    }
    
    public void Event.setInvitees(Map<Account, EventInvitee> invitees) {
        this.invitees = invitees;
    }
    
    public String Event.getLocation() {
        return this.location;
    }
    
    public void Event.setLocation(String location) {
        this.location = location;
    }
    
}
