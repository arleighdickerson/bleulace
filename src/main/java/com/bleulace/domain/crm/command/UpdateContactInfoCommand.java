package com.bleulace.domain.crm.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import com.bleulace.domain.crm.model.Account;
import com.bleulace.domain.crm.model.ContactInformation;
import com.bleulace.utils.ctx.SpringApplicationContext;
import com.bleulace.utils.jpa.EntityManagerReference;

public class UpdateContactInfoCommand extends ContactInformation
{
	@TargetAggregateIdentifier
	private final String id;

	public UpdateContactInfoCommand(String id)
	{
		Assert.notNull(id);
		SpringApplicationContext
				.get()
				.getBean(ModelMapper.class)
				.map(EntityManagerReference.get()
						.getReference(Account.class, id)
						.getContactInformation(), this);
		this.id = id;
	}

	public String getId()
	{
		return id;
	}
}
