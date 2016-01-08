package co.com.binariasystems.gestpymesoc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.binariasystems.fmw.vweb.constants.UIConstants;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Theme(value=UIConstants.BINARIA_THEME)
public class GestPymeSOC extends UI{
	Logger LOGGER = LoggerFactory.getLogger(GestPymeSOC.class);
	@Override
	protected void init(VaadinRequest request) {
		
	}

}
