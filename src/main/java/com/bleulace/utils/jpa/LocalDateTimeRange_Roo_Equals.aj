// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.utils.jpa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

privileged aspect LocalDateTimeRange_Roo_Equals {
    
    public boolean LocalDateTimeRange.equals(Object obj) {
        if (!(obj instanceof LocalDateTimeRange)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        LocalDateTimeRange rhs = (LocalDateTimeRange) obj;
        return new EqualsBuilder().append(end, rhs.end).append(start, rhs.start).isEquals();
    }
    
    public int LocalDateTimeRange.hashCode() {
        return new HashCodeBuilder().append(end).append(start).toHashCode();
    }
    
}
