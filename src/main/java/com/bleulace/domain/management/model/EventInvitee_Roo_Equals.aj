// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.domain.management.model;

import com.bleulace.domain.management.model.EventInvitee;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

privileged aspect EventInvitee_Roo_Equals {
    
    public boolean EventInvitee.equals(Object obj) {
        if (!(obj instanceof EventInvitee)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        EventInvitee rhs = (EventInvitee) obj;
        return new EqualsBuilder().append(guest, rhs.guest).append(host, rhs.host).append(status, rhs.status).isEquals();
    }
    
    public int EventInvitee.hashCode() {
        return new HashCodeBuilder().append(guest).append(host).append(status).toHashCode();
    }
    
}
