// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.domain.management.model;

import com.bleulace.domain.management.model.EventParticipant;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

privileged aspect EventParticipant_Roo_Equals {
    
    public boolean EventParticipant.equals(Object obj) {
        if (!(obj instanceof EventParticipant)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        EventParticipant rhs = (EventParticipant) obj;
        return new EqualsBuilder().append(account, rhs.account).append(status, rhs.status).isEquals();
    }
    
    public int EventParticipant.hashCode() {
        return new HashCodeBuilder().append(account).append(status).toHashCode();
    }
    
}