// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.mgt.presentation;

import com.bleulace.mgt.presentation.EventDTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

privileged aspect EventDTO_Roo_Equals {
    
    public boolean EventDTO.equals(Object obj) {
        if (!(obj instanceof EventDTO)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        EventDTO rhs = (EventDTO) obj;
        return new EqualsBuilder().append(complete, rhs.complete).append(id, rhs.id).append(title, rhs.title).isEquals();
    }
    
    public int EventDTO.hashCode() {
        return new HashCodeBuilder().append(complete).append(id).append(title).toHashCode();
    }
    
}
