package com.bleulace.domain.crm.ui.profile;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.Range;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.axonframework.domain.GenericEventMessage;
import org.axonframework.eventhandling.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

import com.bleulace.domain.crm.presentation.UserDTO;
import com.bleulace.domain.management.ui.calendar.CalendarType;
import com.bleulace.utils.dto.Mapper;
import com.bleulace.web.stereotype.Screen;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.components.calendar.event.CalendarEventProvider;

@Screen("profileView")
class ProfileViewImpl extends CustomComponent implements ProfileView, View
{
	@Autowired
	private transient ApplicationContext ctx;

	@Autowired
	@Qualifier("uiBus")
	private transient EventBus uiBus;

	@Autowired
	@Qualifier("profileMenuBar")
	private Component menuBar;

	@Autowired
	@Qualifier("calendarOps")
	private Component calendarOps;

	@Autowired
	@Qualifier("profileCalendar")
	private Calendar calendar;

	private final AvatarContainer avatar = new AvatarContainer();

	private final InfoComponent infoTable = new InfoComponent();

	private final ResourceListComponent projects = new ResourceListComponent(
			"project");
	private final ResourceListComponent events = new ResourceListComponent(
			"events");

	private ComponentContainer leftLayout;
	private ComponentContainer midLayout;
	private ComponentContainer rightLayout;

	private HorizontalSplitPanel leftPanel;
	private HorizontalSplitPanel rightPanel;

	@PostConstruct
	protected void init()
	{
		leftLayout = makeLeftLayout();
		midLayout = makeMidLayout();
		rightLayout = makeRightLayout();

		rightPanel = new HorizontalSplitPanel(midLayout, rightLayout);
		rightPanel.setSplitPosition(70f, Unit.PERCENTAGE, true);
		rightPanel.setLocked(false);

		leftPanel = new HorizontalSplitPanel(leftLayout, rightPanel);
		leftPanel.setSplitPosition(20f, Unit.PERCENTAGE);
		leftPanel.setLocked(false);

		setCompositionRoot(leftPanel);
	}

	@RequiresAuthentication
	@Override
	public void enter(ViewChangeEvent event)
	{
		leftPanel.setHeight(getUI().getPage().getBrowserWindowHeight(),
				Unit.PIXELS);
		calendar.setHeight(getUI().getPage().getBrowserWindowHeight(),
				Unit.PIXELS);

		Range<Date> range = CalendarType.DAY.convert(new Date());

		calendar.setStartDate(range.getMinimum());
		calendar.setEndDate(range.getMaximum());
		calendar.setEventProvider((CalendarEventProvider) ctx.getBean(
				"eventProvider", event.getParameters(), SecurityUtils
						.getSubject().getId()));

		uiBus.publish(GenericEventMessage.asEventMessage(event));
	}

	@Override
	public void setInfo(UserDTO dto)
	{
		String name = dto.getFirstName();
		avatar.setCaption(name);
		Mapper.map(dto, infoTable);
		projects.setCaption(name + "'s projects");
		events.setCaption(name + "'s events");
		// searchField.setCaption("Search " + name + "'s events");
	}

	@Override
	public void setProjects(Map<String, String> idTitleMap)
	{
		populateResourceTable(projects, idTitleMap);
	}

	@Override
	public void setEvents(Map<String, String> idTitleMap)
	{
		populateResourceTable(events, idTitleMap);
	}

	private ComponentContainer makeLeftLayout()
	{
		VerticalLayout layout = new VerticalLayout(avatar, infoTable, projects,
				events);
		return layout;
	}

	private ComponentContainer makeMidLayout()
	{
		menuBar.setWidth(100f, Unit.PERCENTAGE);
		menuBar.setHeight(null);

		VerticalLayout layout = new VerticalLayout(menuBar);

		layout.setSpacing(false);
		layout.setHeight(100f, Unit.PERCENTAGE);

		return layout;
	}

	private ComponentContainer makeRightLayout()
	{
		VerticalLayout top = new VerticalLayout(calendarOps);
		top.setSizeFull();
		top.setComponentAlignment(calendarOps, Alignment.BOTTOM_CENTER);

		// Panel Rules Everything Around Me.
		VerticalSplitPanel panel = new VerticalSplitPanel(top, calendar);
		calendarOps.setWidth(100f, Unit.PERCENTAGE);
		panel.setSplitPosition(10f, Unit.PERCENTAGE);

		calendar.setWidth(100f, Unit.PERCENTAGE);

		panel.setSizeFull();
		return panel;
	}

	private void populateResourceTable(ResourceListComponent table,
			Map<String, String> data)
	{
		table.clearAllResources();
		for (Entry<String, String> entry : data.entrySet())
		{
			table.addResource(entry.getKey(), entry.getValue());
		}
	}
}