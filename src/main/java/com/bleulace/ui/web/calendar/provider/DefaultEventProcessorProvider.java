package com.bleulace.ui.web.calendar.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
class DefaultEventProcessorProvider implements EventDTOProcessorProvider
{
	@Override
	public EventDTOProcessor[] getProcessors(String ownerId, String viewerId)
	{
		List<EventDTOProcessor> processors = new ArrayList<EventDTOProcessor>();
		return processors.toArray(new EventDTOProcessor[processors.size()]);
	}
}