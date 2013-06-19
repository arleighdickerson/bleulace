package net.bluelace.ui.web;

import net.bluelace.ui.web.front.FrontViewImpl;
import net.bluelace.ui.web.rubiks.CalendarViewImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Configurable
@Theme("runo")
public class BluelaceWebUI extends UI
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2191009197124553972L;

	@Autowired
	private transient ApplicationContext ctx;

	@Override
	protected void init(VaadinRequest request)
	{
		Navigator navigator = new Navigator(this, this);
		navigator.addView("front", FrontViewImpl.class);
		navigator.addView("calendar", CalendarViewImpl.class);
		navigator.navigateTo("front");
	}
}