package co.com.binariasystems.gestpymesoc.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.binariasystems.fmw.security.FMWSecurityException;
import co.com.binariasystems.fmw.security.mgt.SecurityManager;
import co.com.binariasystems.fmw.security.model.AuthenticationRequest;
import co.com.binariasystems.fmw.security.model.AuthorizationRequest;
import co.com.binariasystems.fmw.vweb.mvp.annotation.Init;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewController;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewController.OnLoad;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewController.OnUnLoad;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewField;
import co.com.binariasystems.fmw.vweb.mvp.controller.AbstractViewController;
import co.com.binariasystems.fmw.vweb.uicomponet.FormPanel;
import co.com.binariasystems.fmw.vweb.uicomponet.FormValidationException;
import co.com.binariasystems.fmw.vweb.uicomponet.MessageDialog;
import co.com.binariasystems.fmw.vweb.uicomponet.MessageDialog.Type;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.ButtonBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.PasswordFieldBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.TextFieldBuilder;
import co.com.binariasystems.fmw.vweb.util.VWebUtils;
import co.com.binariasystems.gestpymesoc.business.dto.AuthenticationDTO;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.UI;

@ViewController
public class AuthenticationViewController extends AbstractViewController{
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationViewController.class);
	
	@ViewField private TextFieldBuilder					usernameTxt;
	@ViewField private PasswordFieldBuilder				passwordTxt;
	@ViewField private CheckBox							rememberMeChk;
	@ViewField private ButtonBuilder					authenticateBtn;
	@ViewField private BeanFieldGroup<AuthenticationDTO> fieldGroup;
	@ViewField private AuthenticationDTO				authenticationDTO;
	@ViewField private FormPanel						loginForm;
	@Autowired
	private SecurityManager								securityManager;
	private AuthentiationViewClickListener 				clickListener;
	
	@Init
	public void init(){
		clickListener = new AuthentiationViewClickListener();
		authenticateBtn.addClickListener(clickListener);
	}
	
	@OnLoad
	public void onLoadController(){
	}
	
	@OnUnLoad
	public void onUnloadController(){
		for(Object propertyId : fieldGroup.getBoundPropertyIds())
			fieldGroup.getItemDataSource().getItemProperty(propertyId).setValue(null);
	}
	
	private VaadinServletRequest getVaadinRequest(){
		return (VaadinServletRequest) VaadinService.getCurrentRequest();
	}

	public void loginButtonClick() throws FormValidationException, FMWSecurityException {
		loginForm.validate();
		LOGGER.info("Autenticando: [username:{}, password:{}, rememberMe:{}]", authenticationDTO.getUsername(), authenticationDTO.getPassword(), authenticationDTO.getRememberMe());
		AuthenticationRequest authRequest = new AuthenticationRequest();
		authRequest.setUsername(authenticationDTO.getUsername());
		authRequest.setPassword(authenticationDTO.getPassword());
		authRequest.setRememberMe(authenticationDTO.getRememberMe());
		authRequest.setHttpRequest(getVaadinRequest().getHttpServletRequest());
		securityManager.authenticate(authRequest);
		
		new MessageDialog("Bienvenido", "La validaci\u00f3n de las credenciales de autenticaci\u00f3n ha sida satisfactoria", Type.INFORMATION)
		.addYesClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				securityManager.logout(new AuthorizationRequest(null, getVaadinRequest().getHttpServletRequest(), getVaadinRequest().getSession()));
				UI.getCurrent().getSession().close();
				Page.getCurrent().setLocation(VWebUtils.getContextPath());
			}
		}).show();
	}
	
	
	
	private class AuthentiationViewClickListener implements ClickListener{
		@Override public void buttonClick(ClickEvent event) {
			try {
				loginButtonClick();
			} catch (FormValidationException | FMWSecurityException ex) {
				MessageDialog.showExceptions(ex, LOGGER);
			}
		}
		
	}
}
