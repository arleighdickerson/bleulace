// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.mgt.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

privileged aspect SingleManagementPermission_Roo_Equals {
    
    public boolean SingleManagementPermission.equals(Object obj) {
        if (!(obj instanceof SingleManagementPermission)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        SingleManagementPermission rhs = (SingleManagementPermission) obj;
        return new EqualsBuilder().append(assignment, rhs.assignment).append(project, rhs.project).isEquals();
    }
    
    public int SingleManagementPermission.hashCode() {
        return new HashCodeBuilder().append(assignment).append(project).toHashCode();
    }
    
}
