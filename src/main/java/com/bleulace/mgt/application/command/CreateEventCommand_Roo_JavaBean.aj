// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.mgt.application.command;

import com.bleulace.mgt.application.command.CreateEventCommand;
import com.bleulace.utils.jpa.DateWindow;

privileged aspect CreateEventCommand_Roo_JavaBean {
    
    public String CreateEventCommand.getLocation() {
        return this.location;
    }
    
    public void CreateEventCommand.setLocation(String location) {
        this.location = location;
    }
    
    public DateWindow CreateEventCommand.getWindow() {
        return this.window;
    }
    
    public void CreateEventCommand.setWindow(DateWindow window) {
        this.window = window;
    }
    
}
