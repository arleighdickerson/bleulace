// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.domain.crm.ui.profile.field;

import com.bleulace.domain.crm.ui.profile.field.UserDTODecorator;
import com.bleulace.domain.management.model.ManagementLevel;
import com.bleulace.domain.management.model.RsvpStatus;

privileged aspect UserDTODecorator_Roo_JavaBean {
    
    public RsvpStatus UserDTODecorator.getStatus() {
        return this.status;
    }
    
    public void UserDTODecorator.setStatus(RsvpStatus status) {
        this.status = status;
    }
    
    public ManagementLevel UserDTODecorator.getLevel() {
        return this.level;
    }
    
    public void UserDTODecorator.setLevel(ManagementLevel level) {
        this.level = level;
    }
    
}
