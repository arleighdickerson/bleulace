package com.bleulace.jpa;

import java.io.Serializable;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;

import com.bleulace.cqrs.event.EventBusAware;
import com.bleulace.domain.resource.model.Resource;

/**
 * Enables implementor of {@link EventBusAware} to acquire a reference to the
 * EventBus by calling the eventBus() method. Also declares classes which appear
 * to be intended for use as event payloads as Serializable.
 * 
 * @author Arleigh Dickerson
 * 
 */
public aspect MessageHandlerAnnotatingAspect
{
	interface Message extends Serializable
	{
	}

	interface Command extends Message
	{
	}

	interface Event extends Message
	{
		String getId();
	}

	declare parents : com.bleulace..event..*Event implements Event;
	declare parents : com.bleulace..command..*Command implements Command;

	declare @method : public void com.bleulace..*.on*(Message+,..) : @EventHandler;
	declare @method : public * com.bleulace..*.handle*(Command+,..) : @CommandHandler;
	declare @constructor : public com.bleulace..new(Command+,..) : @CommandHandler;

	pointcut resourceEventHandler(Resource resource, Event event) : 
		execution(@EventHandler void Resource+.*(..,Event+,..))
		&& target(resource)
		&& args(event);

	void around(Resource resource, Event event) : 
		resourceEventHandler(resource,event)
	{
		String eventId = event.getId();
		if (eventId == null || resource.getId().equals(eventId))
		{
			proceed(resource, event);
		}
	}
}