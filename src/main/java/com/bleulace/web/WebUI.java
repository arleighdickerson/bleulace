package com.bleulace.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;

import com.bleulace.web.demo.front.FrontPresenter;
import com.porotype.iconfont.FontAwesome;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

//@formatter:off
/**
 * @founder Hamid Bundu
 * @founder Arleigh Dickerson
 * 
 * @author Arleigh Dickerson
 */
//@formatter:on
@Push
@Theme("bleulacetheme")
@Configurable(preConstruction = true)
@PreserveOnRefresh
@Widgetset("com.vaadin.DefaultWidgetSet")
public class WebUI extends UI
{
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private FrontPresenter frontPresenter;

	@Autowired(required = false)
	private DatabasePopulator pop;

	@Override
	protected void init(VaadinRequest request)
	{
		FontAwesome.load();
		try
		{
			pop.populate();
		}
		catch (Exception e)
		{
		}
		setNavigator((Navigator) ctx.getBean("navigator", this));
		frontPresenter.react();
	}
}