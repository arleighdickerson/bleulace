// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.web.demo.timebox;

import com.bleulace.domain.management.model.RsvpStatus;

privileged aspect ParticipantBean_Roo_JavaBean {
    
    public String ParticipantBean.getId() {
        return this.id;
    }
    
    public void ParticipantBean.setId(String id) {
        this.id = id;
    }
    
    public String ParticipantBean.getFirstName() {
        return this.firstName;
    }
    
    public void ParticipantBean.setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String ParticipantBean.getLastName() {
        return this.lastName;
    }
    
    public void ParticipantBean.setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String ParticipantBean.getEmail() {
        return this.email;
    }
    
    public void ParticipantBean.setEmail(String email) {
        this.email = email;
    }
    
    public RsvpStatus ParticipantBean.getStatus() {
        return this.status;
    }
    
    public void ParticipantBean.setStatus(RsvpStatus status) {
        this.status = status;
    }
    
}
