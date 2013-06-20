// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.bluelace.domain.calendar;

import java.util.Date;
import java.util.Map;
import net.bluelace.domain.account.Account;
import net.bluelace.domain.calendar.CalendarEntry;
import net.bluelace.domain.calendar.ParticipationStatus;

privileged aspect CalendarEntry_Roo_JavaBean {
    
    public Map<Account, ParticipationStatus> CalendarEntry.getParticipants() {
        return this.participants;
    }
    
    public void CalendarEntry.setParticipants(Map<Account, ParticipationStatus> participants) {
        this.participants = participants;
    }
    
    public String CalendarEntry.getCaption() {
        return this.caption;
    }
    
    public void CalendarEntry.setCaption(String caption) {
        this.caption = caption;
    }
    
    public String CalendarEntry.getDescription() {
        return this.description;
    }
    
    public void CalendarEntry.setDescription(String description) {
        this.description = description;
    }
    
    public Date CalendarEntry.getStart() {
        return this.start;
    }
    
    public Date CalendarEntry.getEnd() {
        return this.end;
    }
    
    public String CalendarEntry.getStyleName() {
        return this.styleName;
    }
    
    public void CalendarEntry.setStyleName(String styleName) {
        this.styleName = styleName;
    }
    
}
