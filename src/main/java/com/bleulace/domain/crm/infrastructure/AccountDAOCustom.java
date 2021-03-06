package com.bleulace.domain.crm.infrastructure;

import java.util.List;

import com.bleulace.domain.crm.model.Account;

interface AccountDAOCustom
{
	public List<String> findFriendIds(String id);

	public List<Account> findFriends(String id);

	public List<Account> findFriendRequests(String id);

	public List<Account> findRandomFriends(String accountId, int count);

	public List<Account> findPeopleYouMightKnow(String accountId, int count);

	public List<Account> findBySearch(String searchTerm);
}