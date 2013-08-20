package com.bleulace.domain.crm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.axonframework.domain.MetaData;
import org.springframework.roo.addon.javabean.RooJavaBean;

import com.bleulace.domain.crm.command.CreateAccountCommand;
import com.bleulace.domain.crm.command.EditInfoCommand;
import com.bleulace.domain.crm.command.FriendRequestCommand;
import com.bleulace.domain.crm.event.AccountCreatedEvent;
import com.bleulace.domain.feed.model.FeedEntry;
import com.bleulace.domain.resource.model.AbstractRootResource;
import com.bleulace.utils.chrono.TimeZoneEnum;
import com.bleulace.utils.dto.Mapper;

@RooJavaBean
@Entity
@Table(name = "ACCOUNT")
public class Account extends AbstractRootResource implements CommentableRoot,
		CommentableResource
{
	@Column(nullable = false, updatable = false, unique = true)
	private String username;

	@Embedded
	private HashedPassword password = new HashedPassword();

	@Embedded
	private ContactInformation contactInformation = new ContactInformation();

	@ElementCollection
	@MapKeyJoinColumn
	private Map<Account, FriendRequest> friendRequests = new HashMap<Account, FriendRequest>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Account> friends = new HashSet<Account>();

	@OrderBy("dateCreated DESC")
	@ElementCollection
	private List<FeedEntry> feedEntries = new ArrayList<FeedEntry>();

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TimeZoneEnum timeZone = TimeZoneEnum.DEFAULT;

	public TimeZone getTimeZone()
	{
		return timeZone.toTimeZone();
	}

	public void setTimeZone(TimeZone timeZone)
	{
		this.timeZone = TimeZoneEnum.fromTimeZone(timeZone);
	}

	public Account()
	{
	}

	public void setPassword(String password)
	{
		if (password != null)
		{
			this.password = new HashedPassword(password);
		}
	}

	public Account(CreateAccountCommand command, MetaData metaData)
	{
		AccountCreatedEvent event = new AccountCreatedEvent();
		event.setId(getId());
		apply(Mapper.map(command, event), metaData);
	}

	public void on(AccountCreatedEvent event, MetaData metaData)
	{
		this.username = event.getUsername();
		setPassword(event.getPassword());
		this.contactInformation = event.getContactInformation();
	}

	public void handle(EditInfoCommand command, MetaData data)
	{
		apply(command, data);
	}

	public void on(EditInfoCommand command, MetaData data)
	{
		contactInformation = command.getInformation();
		setPassword(command.getPassword());
	}

	public void handle(FriendRequestCommand command, MetaData data)
	{
		apply(command, data);
	}

	public void on(FriendRequestCommand event, MetaData metaData)
	{
		event.getAction().execute(this, metaData);
	}

	@PreRemove
	public void preRemove()
	{
		for (Account friend : friends)
		{
			friends.remove(friend);
		}
	}
}