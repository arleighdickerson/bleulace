package com.bleulace.web.demo.timebox;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;

import com.bleulace.domain.crm.model.Account;
import com.bleulace.domain.management.model.ManagementRole;
import com.bleulace.domain.management.model.Manager;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.data.util.AbstractBeanContainer.BeanIdResolver;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Table;

import de.steinwedel.messagebox.ButtonId;
import de.steinwedel.messagebox.Icon;
import de.steinwedel.messagebox.MessageBox;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Configurable(preConstruction = true)
public class ManagerField extends CustomField<List> implements
		Button.ClickListener, Handler
{
	@Autowired
	@Qualifier("friendContainer")
	private JPAContainer<Account> candidates;

	private final BeanContainer<String, Manager> managers = makeContainer();

	//@formatter:off
	private final Action[] actions = new Action[] { 
			new ManagerAction(ManagementRole.LOOP, "Loop"),
			new ManagerAction(ManagementRole.MIX, "Mix"),
			new ManagerAction(ManagementRole.OWN, "Own"),
	};
	//@formatter:on

	public ManagerField()
	{
		setBuffered(true);
	}

	@Override
	protected Component initContent()
	{
		return new Button("Managers", this);
	}

	@Override
	public Class<? extends List> getType()
	{
		return List.class;
	}

	@Override
	protected void setInternalValue(List newValue)
	{
		managers.addAll(newValue);
		super.setInternalValue(newValue);
	}

	@Override
	public void buttonClick(ClickEvent event)
	{
		FormLayout form = new FormLayout(makeComboBox(), makeTable());
		MessageBox box = MessageBox.showCustomized(Icon.NONE, "Add Managers",
				form, ButtonId.CANCEL, ButtonId.SAVE);
		box.getWindow().setDraggable(false);
		box.getButton(ButtonId.SAVE).addClickListener(
				new Button.ClickListener()
				{
					@Override
					public void buttonClick(ClickEvent event)
					{
						commit();
					}
				});
		box.getButton(ButtonId.SAVE).setClickShortcut(KeyCode.ENTER);
		box.getButton(ButtonId.CANCEL).addClickListener(
				new Button.ClickListener()
				{
					@Override
					public void buttonClick(ClickEvent event)
					{
						discard();
					}
				});
		box.getButton(ButtonId.CANCEL).setClickShortcut(KeyCode.ESCAPE);
	}

	@Override
	public Action[] getActions(Object target, Object sender)
	{
		return target == null ? new Action[] {} : actions;
	}

	@Override
	public void handleAction(Action action, Object sender, Object target)
	{
		Assert.notNull(target);
		if (action instanceof ManagerAction)
		{
			Table table = (Table) sender;
			table.getItem(target).getItemProperty("role")
					.setValue(((ManagerAction) action).level);
		}
	}

	private static class ManagerAction extends Action
	{
		private final ManagementRole level;

		ManagerAction(ManagementRole level, String caption)
		{
			super(caption);
			this.level = level;
		}
	}

	private ComboBox makeComboBox()
	{
		final ComboBox bean = new ComboBox();
		bean.setContainerDataSource(candidates);
		bean.setItemCaptionMode(ItemCaptionMode.PROPERTY);
		bean.setItemCaptionPropertyId("title");
		bean.setImmediate(true);
		bean.addValueChangeListener(new ValueChangeListener()
		{
			@Override
			public void valueChange(
					com.vaadin.data.Property.ValueChangeEvent event)
			{
				String id = (String) event.getProperty().getValue();
				if (id != null && !managers.containsId(id))
				{
					Manager bean = new Manager(candidates.getItem(id)
							.getEntity(), ManagementRole.LOOP);
					managers.addBean(bean);
					getInternalValue().add(bean);
				}
			}
		});
		return bean;
	}

	private Table makeTable()
	{
		final Table bean = new Table("Managers", managers);
		bean.addActionHandler(this);
		bean.setPageLength(6);
		bean.setVisibleColumns(new Object[] {
				"account.contactInformation.firstName",
				"account.contactInformation.lastName",
				"account.contactInformation.email", "role" });
		bean.setImmediate(true);
		bean.setSelectable(true);

		bean.addShortcutListener(new ShortcutListener("Delete", KeyCode.DELETE,
				null)
		{
			@Override
			public void handleAction(Object sender, Object target)
			{
				String id = (String) bean.getValue();
				if (id != null)
				{
					managers.removeItem(id);
				}
			}
		});

		return bean;
	}

	private BeanContainer<String, Manager> makeContainer()
	{
		BeanContainer<String, Manager> container = new BeanContainer<String, Manager>(
				Manager.class);
		container
				.addNestedContainerProperty("account.contactInformation.firstName");
		container
				.addNestedContainerProperty("account.contactInformation.lastName");
		container
				.addNestedContainerProperty("account.contactInformation.email");
		container.setBeanIdResolver(new BeanIdResolver<String, Manager>()
		{
			@Override
			public String getIdForBean(Manager bean)
			{
				return bean.getAccount().getId();
			}
		});
		return container;
	}

	private Button makeButton(String caption, int keyCode,
			Button.ClickListener listener)
	{
		Button b = new Button(caption, listener);
		b.setClickShortcut(keyCode);
		return b;
	}
}