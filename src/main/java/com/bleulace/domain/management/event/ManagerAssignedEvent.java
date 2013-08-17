package com.bleulace.domain.management.event;

import org.springframework.roo.addon.javabean.RooJavaBean;

import com.bleulace.domain.management.model.ManagementLevel;

@RooJavaBean(settersByDefault = false)
public class ManagerAssignedEvent
{
	private String assigneeId;

	private ManagementLevel role;

	public ManagerAssignedEvent(String assigneeId, ManagementLevel role)
	{
		this.assigneeId = assigneeId;
		this.role = role;
	}
}
