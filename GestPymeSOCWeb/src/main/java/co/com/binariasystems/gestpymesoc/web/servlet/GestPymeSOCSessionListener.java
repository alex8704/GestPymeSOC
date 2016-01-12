package co.com.binariasystems.gestpymesoc.web.servlet;

import javax.servlet.http.Cookie;

import org.apache.commons.lang3.LocaleUtils;

import co.com.binariasystems.fmw.vweb.constants.VWebCommonConstants;

import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;

public class GestPymeSOCSessionListener implements SessionInitListener, SessionDestroyListener {

	@Override
	public void sessionDestroy(SessionDestroyEvent event) {
		System.out.println("Session destruida en VAADIN -----> GODD BYE");
	}

	@Override
	public void sessionInit(SessionInitEvent event) throws ServiceException {
		Cookie langCookie = null;
		if (event.getRequest() != null) {
			for (Cookie cookie : event.getRequest().getCookies())
				if (cookie.getName().equals(VWebCommonConstants.USER_LANGUAGE_APPCOOKIE)) {
					langCookie = cookie;
					break;
				}
		}

		if (langCookie == null)
			langCookie = createLanguageCookie(event.getRequest());
		event.getSession().setLocale(LocaleUtils.toLocale(langCookie.getValue()));
		VaadinService.getCurrentResponse().addCookie(langCookie);
	}
	
	private Cookie createLanguageCookie(VaadinRequest request){
		Cookie langCookie = new Cookie(VWebCommonConstants.USER_LANGUAGE_APPCOOKIE, request.getLocale().toString());
		langCookie.setPath(request.getContextPath());
		return langCookie;
	}

}
