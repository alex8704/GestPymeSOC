package co.com.binariasystems.gestpymesoc.web.view;

import co.com.binariasystems.fmw.vweb.mvp.annotation.DashBoard;
import co.com.binariasystems.fmw.vweb.mvp.annotation.View;
import co.com.binariasystems.fmw.vweb.mvp.annotation.View.Root;
import co.com.binariasystems.fmw.vweb.mvp.annotation.ViewBuild;
import co.com.binariasystems.fmw.vweb.mvp.views.AbstractView;
import co.com.binariasystems.fmw.vweb.uicomponet.PanelGroup;
import co.com.binariasystems.fmw.vweb.uicomponet.TreeMenu;
import co.com.binariasystems.fmw.vweb.uicomponet.builders.LabelBuilder;
import co.com.binariasystems.gestpymesoc.web.controller.DashboardViewController;
import co.com.binariasystems.gestpymesoc.web.utils.GPSWebConstants;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

@DashBoard
@Root(contentSetterMethod="setCurrentView")
@View(url="/", controller=DashboardViewController.class, messages=AuthenticationView.MESSAGES_BUNDLE, viewStringsByConventions= true)
public class DashboardView extends AbstractView implements GPSWebConstants {
	public static final String		MESSAGES_BUNDLE = GPSWebConstants.MESSAGES_PACKAGE + "." + MAIN_MESSAGES_FILE;
	private VerticalLayout mainContainer;
	private HorizontalLayout topPanel;
	private HorizontalSplitPanel menuDivisorSplitPanel;
	private VerticalSplitPanel centralSplitPanel;
	private PanelGroup accountInfoPanel;
	private LabelBuilder welcomeLbl;
	private Label currentUserNameLbl;
	private TreeMenu treeMenu;
	
	
	@ViewBuild
	public Component build(){
		mainContainer = new VerticalLayout();
		topPanel = new HorizontalLayout();
		menuDivisorSplitPanel = new HorizontalSplitPanel();
		centralSplitPanel = new VerticalSplitPanel();
		accountInfoPanel = new PanelGroup(2);
		treeMenu = new TreeMenu();
		welcomeLbl = new LabelBuilder();
		currentUserNameLbl = new Label();
		
		mainContainer.addComponent(topPanel);
		mainContainer.addComponent(menuDivisorSplitPanel);
		mainContainer.setSizeFull();
		mainContainer.setExpandRatio(menuDivisorSplitPanel, 1.0f);
		
		topPanel.setHeight(40, Unit.PIXELS);
		
		menuDivisorSplitPanel.setFirstComponent(treeMenu);
		menuDivisorSplitPanel.setSecondComponent(centralSplitPanel);
		menuDivisorSplitPanel.setSplitPosition(250, Unit.PIXELS);
		
		centralSplitPanel.setFirstComponent(accountInfoPanel);
		centralSplitPanel.setSplitPosition(25, Unit.PIXELS);
		centralSplitPanel.setLocked(true);
		
		accountInfoPanel.add(welcomeLbl);
		accountInfoPanel.add(currentUserNameLbl);
		
		welcomeLbl.boldStyle();
		
		return mainContainer;
	}
	
	
	
	public void setCurrentView(Component component){
		centralSplitPanel.setSecondComponent(component);
	}
}
