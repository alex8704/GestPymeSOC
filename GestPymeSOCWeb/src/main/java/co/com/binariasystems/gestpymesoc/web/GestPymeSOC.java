package co.com.binariasystems.gestpymesoc.web;

import java.text.MessageFormat;

import co.com.binariasystems.fmw.ioc.IOCHelper;
import co.com.binariasystems.fmw.security.mgt.SecurityManager;
import co.com.binariasystems.fmw.security.model.AuthorizationRequest;
import co.com.binariasystems.fmw.util.messagebundle.MessageBundleManager;
import co.com.binariasystems.fmw.vweb.constants.UIConstants;
import co.com.binariasystems.fmw.vweb.util.LocaleMessagesUtil;
import co.com.binariasystems.gestpymesoc.web.resources.resources;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Page.UriFragmentChangedListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.ui.UI;

@Theme(value=UIConstants.BINARIA_THEME)
public class GestPymeSOC extends UI{
	//private static final Logger LOGGER = LoggerFactory.getLogger(GestPymeSOC.class);
	@Override
	protected void init(VaadinRequest vaadinRequest) {
		SecurityManager securityManager = IOCHelper.getBean(SecurityManager.class);
		getPage().setTitle(getApplicationTitle());
		UriFragmentChangedListener uriFragmentListener = IOCHelper.getBean(UriFragmentChangedListener.class);
		getPage().addUriFragmentChangedListener(uriFragmentListener);
		getPage().setUriFragment(securityManager.isAuthenticated(getAuthorizationRequest(vaadinRequest)) ? securityManager.getDashBoardViewUrl() : "/");
	}
	
	private String getApplicationTitle(){
		MessageBundleManager messages = MessageBundleManager.forPath(resources.getMessageFilePath("gestpymesoc_view_messages"));
		MessageFormat titleFmt = new MessageFormat(LocaleMessagesUtil.getLocalizedMessage(messages, "GestPymeSOC.applicationTitle"));
		return titleFmt.format(new String[]{System.getProperty("gestpymesoc.applicationVersion")});
	}
	
	private AuthorizationRequest getAuthorizationRequest(VaadinRequest vaadinRequest){
		VaadinServletRequest request =  (VaadinServletRequest) VaadinService.getCurrentRequest();
		return new AuthorizationRequest(null, request.getHttpServletRequest(), request.getSession());
	}
}
