package co.com.binariasystems.gestpymesoc.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.binariasystems.fmw.vweb.mvp.annotation.Init;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewController;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewController.OnLoad;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewController.OnUnLoad;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewField;
import co.com.binariasystems.fmw.vweb.mvp.controller.AbstractViewController;
import co.com.binariasystems.fmw.vweb.uicomponet.FormPanel;
import co.com.binariasystems.fmw.vweb.uicomponet.FormValidationException;
import co.com.binariasystems.fmw.vweb.uicomponet.MessageDialog;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.ButtonBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.PasswordFieldBuilder;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.TextFieldBuilder;
import co.com.binariasystems.gestpymesoc.business.dto.AuthenticationDTO;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;

@ViewController
public class AuthenticationViewController extends AbstractViewController{
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationViewController.class);
	
	@ViewField private TextFieldBuilder					usernameTxt;
	@ViewField private PasswordFieldBuilder				passwordTxt;
	@ViewField private CheckBox							rememberMeChk;
	@ViewField private ButtonBuilder					authenticateBtn;
	@ViewField private BeanItem<AuthenticationDTO> 		dataSource;
	@ViewField private FieldGroup 						fieldGroup;
	@ViewField private FormPanel						loginForm;
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
		for(Object propertyId : dataSource.getItemPropertyIds())
			dataSource.getItemProperty(propertyId).setValue(null);
	}

	public void loginButtonClick() throws FormValidationException {
		loginForm.validate();
		LOGGER.info("Autenticando: [username:{}, password:{}, rememberMe:{}]", dataSource.getBean().getUsername(), dataSource.getBean().getPassword(), dataSource.getBean().getRememberMe());
	}
	
	
	private class AuthentiationViewClickListener implements ClickListener{
		@Override public void buttonClick(ClickEvent event) {
			try {
				loginButtonClick();
			} catch (FormValidationException ex) {
				MessageDialog.showExceptions(ex, LOGGER);
			}
		}
		
	}
}
