package com.bleulace.domain.crm.ui.profile;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.domain.GenericEventMessage;
import org.axonframework.eventhandling.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;

import com.bleulace.domain.crm.ui.profile.ProfileView.CalendarDirtiedEvent;
import com.bleulace.domain.crm.ui.profile.field.ParticipantFieldFactory;
import com.bleulace.domain.management.command.CreateEventCommand;
import com.bleulace.domain.management.command.EditEventCommand;
import com.bleulace.domain.management.presentation.EventDTO;
import com.bleulace.utils.dto.Mapper;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@Configurable(preConstruction = true)
class EventWindow extends Window
{
	@Autowired
	private CommandGateway gateway;

	@Autowired
	@Qualifier("uiBus")
	private EventBus uiBus;

	@Autowired
	private ParticipantFieldFactory fieldFactory;

	@Autowired
	private Handler handler;

	private final BeanFieldGroup<CreateEventCommand> group = new BeanFieldGroup<CreateEventCommand>(
			CreateEventCommand.class);

	private static final String CREATE_CAPTION = "Create Event";
	private static final String EDIT_CAPTION = "Edit Event";

	// too long
	EventWindow(EventDTO dto)
	{
		fieldFactory.setEvent(dto);
		setCaption(dto.getId() == null ? CREATE_CAPTION : EDIT_CAPTION);
		setModal(true);
		setResizable(false);
		group.setItemDataSource(Mapper.map(dto,
				dto.getId() == null ? new CreateEventCommand()
						: new EditEventCommand(dto.getId())));
		group.setBuffered(false);

		FormLayout form = new FormLayout();

		form.addComponent(group.buildAndBind("title"));
		form.addComponent(group.buildAndBind("location"));

		DateField startField = makeDateField();
		DateField endField = makeDateField();
		group.bind(startField, "start");
		group.bind(endField, "end");
		form.addComponent(startField);
		form.addComponent(endField);

		group.bind(fieldFactory.getInviteeField(), "inviteeIds");
		group.bind(fieldFactory.getManagerField(), "assignments");

		form.addComponent(fieldFactory.getContent());
		addActionHandler(handler);

		HorizontalLayout buttons = new HorizontalLayout();
		buttons.setSpacing(true);

		buttons.addComponent(new Button("Delete", new DeleteListener()));
		buttons.addComponent(new Button("Apply", new ApplyListener()));

		Button cancel = new Button("Cancel", new CancelListener());
		cancel.setClickShortcut(KeyCode.ESCAPE);
		buttons.addComponent(cancel);

		VerticalLayout content = new VerticalLayout(form, buttons);
		content.setComponentAlignment(buttons, Alignment.BOTTOM_RIGHT);
		setContent(content);
	}

	private DateField makeDateField()
	{
		DateField field = new DateField();
		field.setResolution(Resolution.MINUTE);
		return field;
	}

	private class ApplyListener implements ClickListener
	{
		@Override
		public void buttonClick(ClickEvent event)
		{
			if (group.isValid())
			{
				try
				{
					gateway.sendAndWait(group.getItemDataSource().getBean());
					uiBus.publish(GenericEventMessage
							.asEventMessage(new CalendarDirtiedEvent()));
					Notification.show("Changes saved.", Type.TRAY_NOTIFICATION);
					close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	private class CancelListener implements ClickListener
	{
		@Override
		public void buttonClick(ClickEvent event)
		{
			close();
			Notification.show("Operation canceled.", Type.TRAY_NOTIFICATION);
		}
	}

	private class DeleteListener implements ClickListener
	{
		@Override
		public void buttonClick(ClickEvent event)
		{
			CreateEventCommand c = group.getItemDataSource().getBean();
			if (!c.getClass().equals(CreateEventCommand.class))
			{
				c.getInviteeIds().clear();
			}
			gateway.send(c);
			uiBus.publish(GenericEventMessage
					.asEventMessage(new CalendarDirtiedEvent()));
			Notification.show("Event deleted.", Type.TRAY_NOTIFICATION);
			close();
		}
	}
}