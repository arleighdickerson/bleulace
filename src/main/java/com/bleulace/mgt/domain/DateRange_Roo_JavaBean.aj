// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.mgt.domain;

import com.bleulace.mgt.domain.DateRange;
import java.util.Date;

privileged aspect DateRange_Roo_JavaBean {
    
    public Date DateRange.getStart() {
        return this.start;
    }
    
    public void DateRange.setStart(Date start) {
        this.start = start;
    }
    
    public Date DateRange.getEnd() {
        return this.end;
    }
    
    public void DateRange.setEnd(Date end) {
        this.end = end;
    }
    
}