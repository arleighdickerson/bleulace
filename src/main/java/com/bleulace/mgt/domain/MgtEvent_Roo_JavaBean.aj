// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.mgt.domain;

import com.bleulace.crm.domain.Account;
import com.bleulace.mgt.domain.MgtEvent;
import java.util.Map;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;

privileged aspect MgtEvent_Roo_JavaBean {
    
    public LocalDateTime MgtEvent.getStart() {
        return this.start;
    }
    
    public void MgtEvent.setStart(LocalDateTime start) {
        this.start = start;
    }
    
    public Period MgtEvent.getLength() {
        return this.length;
    }
    
    public void MgtEvent.setLength(Period length) {
        this.length = length;
    }
    
    public Map<Account, Role> MgtEvent.getAttendees() {
        return this.attendees;
    }
    
    public void MgtEvent.setAttendees(Map<Account, Role> attendees) {
        this.attendees = attendees;
    }
    
}
