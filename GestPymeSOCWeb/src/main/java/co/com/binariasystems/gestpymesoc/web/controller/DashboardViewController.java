package co.com.binariasystems.gestpymesoc.web.controller;

import java.util.List;

import co.com.binariasystems.fmw.annotation.Dependency;
import co.com.binariasystems.fmw.security.FMWSecurityException;
import co.com.binariasystems.fmw.security.mgt.SecurityManager;
import co.com.binariasystems.fmw.security.model.AuthorizationRequest;
import co.com.binariasystems.fmw.vweb.mvp.annotation.Init;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewController;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewController.OnLoad;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewField;
import co.com.binariasystems.fmw.vweb.mvp.controller.AbstractViewController;
import co.com.binariasystems.fmw.vweb.uicomponet.MessageDialog;
import co.com.binariasystems.fmw.vweb.uicomponet.MessageDialog.Type;
import co.com.binariasystems.fmw.vweb.uicomponet.TreeMenu;
import co.com.binariasystems.fmw.vweb.uicomponet.treemenu.MenuElement;
import co.com.binariasystems.fmw.vweb.util.VWebUtils;
import co.com.binariasystems.gestpymesoc.web.security.GPSAuditoryDataProvider;
import co.com.binariasystems.gestpymesoc.web.utils.GPSMenuGenerator;
import co.com.binariasystems.gestpymesoc.web.utils.MenuAction;
import co.com.binariasystems.gestpymesoc.web.utils.MenuOption;
import co.com.binariasystems.orion.model.dto.AccessTokenDTO;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@ViewController
public class DashboardViewController extends AbstractViewController{
	@ViewField private Label currentUserNameLbl;
	@ViewField private TreeMenu treeMenu;
	@Dependency
	private GPSMenuGenerator menuGenerator;
	@Dependency 
	private GPSAuditoryDataProvider auditoryDataProvider;
	@Dependency
	private SecurityManager securityManager;
	
	private ValueChangeListener valueChangeListener;
	private ClickListener clickListener;
	private MessageDialog logoutConfirmDialog;
	
	@Init
	public void init(){
		valueChangeListener = new DashboardViewValueChangeListener();
		clickListener = new DashboardViewClickListener();
		logoutConfirmDialog = new MessageDialog(getText("DashboardView.closeSession.caption"), getText("DashboardView.questionDialog.closeSession"), Type.QUESTION);
		
		treeMenu.addValueChangeListener(valueChangeListener);
		logoutConfirmDialog.addYesClickListener(clickListener);
	}
	
	@OnLoad
	public void onLoad() throws FMWSecurityException{
		AccessTokenDTO accountInfo = auditoryDataProvider.getCurrenAuditoryUserByServletRequest(getVaadinRequest().getHttpServletRequest());
		List<MenuElement> menuOptions = menuGenerator.generateMenuItems(getVaadinRequest().getHttpServletRequest());
		menuOptions.add(new MenuAction(getText("DashboardView.closeSession.caption"), getText("DashboardView.closeSession.caption"), "DashboardView.closeSession"));
		treeMenu.setItems(menuOptions);
		currentUserNameLbl.setValue(accountInfo.getUser().getFullName());
	}
	
	private void treeMenuValueChange(ValueChangeEvent event){
		if(event.getProperty().getValue() instanceof MenuOption){
			MenuOption option = (MenuOption)event.getProperty().getValue();
			Page.getCurrent().setUriFragment(option.getPath());
		}else if(event.getProperty().getValue() instanceof MenuAction){
			treeMenuHanldeAction((MenuAction)event.getProperty().getValue());
		}
	}
	
	private void treeMenuHanldeAction(MenuAction action){
		if("DashboardView.closeSession".equals(action.getActionId()))
			logoutConfirmDialog.show();
	}
	
	private void logoutYesButtonClick(ClickEvent event){
		securityManager.logout(new AuthorizationRequest(null, getVaadinRequest().getHttpServletRequest(), getVaadinRequest().getSession()));
		UI.getCurrent().getSession().close();
		Page.getCurrent().setLocation(VWebUtils.getContextPath());
	}
	
	/*----------------------------------------------------------------------------------------------------------------------
	 * Clases Privadas para el manejo de enventos en lugar de clases Anonimas
	 * Y metodos utiles
	 ----------------------------------------------------------------------------------------------------------------------*/
	
	private VaadinServletRequest getVaadinRequest(){
		return (VaadinServletRequest) VaadinService.getCurrentRequest();
	}
	
	private class DashboardViewValueChangeListener implements ValueChangeListener{
		@Override public void valueChange(ValueChangeEvent event) {
			if(event.getProperty().equals(treeMenu.getPropertyDS()))
				treeMenuValueChange(event);
		}
	}
	
	private class DashboardViewClickListener implements ClickListener{
		@Override public void buttonClick(ClickEvent event) {
			if(event.getSource().equals(logoutConfirmDialog.yesButton()))
				logoutYesButtonClick(event);
		}
		
	}
}
