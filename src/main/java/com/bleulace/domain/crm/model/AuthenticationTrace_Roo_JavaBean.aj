// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.domain.crm.model;

import com.bleulace.domain.crm.model.AuthenticationTrace;
import java.util.Date;

privileged aspect AuthenticationTrace_Roo_JavaBean {
    
    public String AuthenticationTrace.getUsername() {
        return this.username;
    }
    
    public boolean AuthenticationTrace.isSuccess() {
        return this.success;
    }
    
    public String AuthenticationTrace.getHost() {
        return this.host;
    }
    
    public Date AuthenticationTrace.getDate() {
        return this.date;
    }
    
}