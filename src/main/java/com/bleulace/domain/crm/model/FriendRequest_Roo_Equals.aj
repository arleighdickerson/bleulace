// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.domain.crm.model;

import com.bleulace.domain.crm.model.FriendRequest;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

privileged aspect FriendRequest_Roo_Equals {
    
    public boolean FriendRequest.equals(Object obj) {
        if (!(obj instanceof FriendRequest)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        FriendRequest rhs = (FriendRequest) obj;
        return new EqualsBuilder().append(dateSent, rhs.dateSent).append(requestor, rhs.requestor).isEquals();
    }
    
    public int FriendRequest.hashCode() {
        return new HashCodeBuilder().append(dateSent).append(requestor).toHashCode();
    }
    
}