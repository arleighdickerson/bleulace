// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.domain.crm.model;

import com.bleulace.domain.crm.model.Account;
import com.bleulace.domain.crm.model.FriendRequest;
import java.util.Date;

privileged aspect FriendRequest_Roo_JavaBean {
    
    public Account FriendRequest.getRequestor() {
        return this.requestor;
    }
    
    public Date FriendRequest.getDateSent() {
        return this.dateSent;
    }
    
}
