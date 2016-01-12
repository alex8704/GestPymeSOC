package co.com.binariasystems.gestpymesoc.web.servlet;

import javax.servlet.ServletException;

import com.vaadin.server.VaadinServlet;

public class GestPymeSOCVaadinServlet extends VaadinServlet {
	private GestPymeSOCSessionListener sessionListener = new GestPymeSOCSessionListener();
	GestPymeSOCSystemMessagesProvider systemMessagesProvider = new GestPymeSOCSystemMessagesProvider();
	@Override
	protected void servletInitialized() throws ServletException {
		super.servletInitialized();
		
		getService().addSessionInitListener(sessionListener);
		getService().addSessionDestroyListener(sessionListener);
		getService().setSystemMessagesProvider(systemMessagesProvider);
	}
}
