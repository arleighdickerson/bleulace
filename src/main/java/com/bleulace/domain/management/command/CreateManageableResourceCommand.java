package com.bleulace.domain.management.command;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.roo.addon.javabean.RooJavaBean;

@RooJavaBean
public class CreateManageableResourceCommand
{
	@NotEmpty
	private String title = "";
}