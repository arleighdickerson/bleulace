// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.crm.application.event;

import com.bleulace.crm.application.event.FriendRequestEvent;

privileged aspect FriendRequestEvent_Roo_JavaBean {
    
    public String FriendRequestEvent.getInitiatorId() {
        return this.initiatorId;
    }
    
    public void FriendRequestEvent.setInitiatorId(String initiatorId) {
        this.initiatorId = initiatorId;
    }
    
    public String FriendRequestEvent.getRecipientId() {
        return this.recipientId;
    }
    
    public void FriendRequestEvent.setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }
    
}
