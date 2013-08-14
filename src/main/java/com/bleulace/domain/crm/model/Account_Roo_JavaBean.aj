// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bleulace.domain.crm.model;

import com.bleulace.domain.crm.model.Account;
import com.bleulace.domain.crm.model.ContactInformation;
import com.bleulace.domain.crm.model.FriendRequest;
import com.bleulace.domain.feed.model.FeedEntry;
import java.util.List;
import java.util.Map;
import java.util.Set;

privileged aspect Account_Roo_JavaBean {
    
    public String Account.getUsername() {
        return this.username;
    }
    
    public void Account.setUsername(String username) {
        this.username = username;
    }
    
    public byte[] Account.getHash() {
        return this.hash;
    }
    
    public void Account.setHash(byte[] hash) {
        this.hash = hash;
    }
    
    public byte[] Account.getSalt() {
        return this.salt;
    }
    
    public void Account.setSalt(byte[] salt) {
        this.salt = salt;
    }
    
    public ContactInformation Account.getContactInfo() {
        return this.contactInfo;
    }
    
    public void Account.setContactInfo(ContactInformation contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    public Map<Account, FriendRequest> Account.getFriendRequests() {
        return this.friendRequests;
    }
    
    public void Account.setFriendRequests(Map<Account, FriendRequest> friendRequests) {
        this.friendRequests = friendRequests;
    }
    
    public Set<Account> Account.getFriends() {
        return this.friends;
    }
    
    public void Account.setFriends(Set<Account> friends) {
        this.friends = friends;
    }
    
    public List<FeedEntry> Account.getFeedEntries() {
        return this.feedEntries;
    }
    
    public void Account.setFeedEntries(List<FeedEntry> feedEntries) {
        this.feedEntries = feedEntries;
    }
    
}
