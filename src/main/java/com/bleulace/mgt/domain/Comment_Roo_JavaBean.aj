// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.mgt.domain;

import com.bleulace.crm.domain.Account;
import com.bleulace.mgt.domain.Comment;
import java.util.Date;

privileged aspect Comment_Roo_JavaBean {
    
    public Account Comment.getAuthor() {
        return this.author;
    }
    
    public String Comment.getContent() {
        return this.content;
    }
    
    public Date Comment.getDatePosted() {
        return this.datePosted;
    }
    
}