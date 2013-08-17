package com.bleulace.utils.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ModelMappingConfig
{
	@Autowired
	private ApplicationContext ctx;

	static final String DEFAULT = "defaultMapper";

	static final String COMMAND_EVENT = "commandEventMapper";

	@Bean(name = DEFAULT)
	public ModelMapper defaultMapper()
	{
		ModelMapper mapper = new ModelMapper();
		for (PropertyMap<?, ?> map : ctx.getBeansOfType(PropertyMap.class)
				.values())
		{
			mapper.addMappings(map);
		}
		return mapper;
	}

	@Bean(name = COMMAND_EVENT)
	public ModelMapper commandEventMapper()
	{
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setFieldAccessLevel(AccessLevel.PRIVATE);
		mapper.getConfiguration().setFieldMatchingEnabled(true);
		return mapper;
	}
}