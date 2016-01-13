package co.com.binariasystems.gestpymesoc.web.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import co.com.binariasystems.fmw.constants.FMWConstants;
import co.com.binariasystems.fmw.entity.util.FMWEntityConstants;
import co.com.binariasystems.fmw.ioc.IOCHelper;
import co.com.binariasystems.fmw.util.db.DBUtil;
import co.com.binariasystems.fmw.util.di.SpringIOCProvider;
import co.com.binariasystems.fmw.vweb.constants.VWebCommonConstants;
import co.com.binariasystems.gestpymesoc.business.bean.GestPymeSOCSystemBean;

/**
 * Application Lifecycle Listener implementation class GestPymeSOCContextListener
 *
 */
public class GestPymeSOCContextListener implements ServletContextListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(GestPymeSOCContextListener.class);
    /**
     * Default constructor. 
     */
    public GestPymeSOCContextListener() {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	IOCHelper.setProvider(SpringIOCProvider.configure(WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext())));
    	DBUtil.init(IOCHelper.getBean("GestPymeSOCDS", DataSource.class));
    	Class resourceLoaderClass = IOCHelper.getBean(FMWConstants.APPLICATION_DEFAULT_CLASS_FOR_RESOURCE_LOAD_IOC_KEY, Class.class);
    	String entitiesStringsFilePath = IOCHelper.getBean(VWebCommonConstants.APP_ENTITIES_MESSAGES_FILE_IOC_KEY, String.class);
    	String entityOperatiosShowSql = IOCHelper.getBean(FMWEntityConstants.ENTITY_OPERATIONS_SHOWSQL_IOC_KEY, String.class);
    	String appVersion = sce.getServletContext().getInitParameter("gestpymesoc.applicationVersion");
    	
    	System.setProperty("gestpymesoc.applicationVersion", appVersion);
    	
    	LOGGER.info(FMWConstants.APPLICATION_DEFAULT_CLASS_FOR_RESOURCE_LOAD_IOC_KEY + ": " + resourceLoaderClass);
    	LOGGER.info(VWebCommonConstants.APP_ENTITIES_MESSAGES_FILE_IOC_KEY + ": " + entitiesStringsFilePath);
    	LOGGER.info(FMWEntityConstants.ENTITY_OPERATIONS_SHOWSQL_IOC_KEY + ": " + entityOperatiosShowSql);
    	
    	if(isDataModelCreated()){
    		initializeApplication();
    	}
    		
    }
    
    private boolean isDataModelCreated(){
    	GestPymeSOCSystemBean systemBean = IOCHelper.getBean(GestPymeSOCSystemBean.class);
    	return systemBean.validateDataModelCreation();
    }
    
    private void initializeApplication(){
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	LOGGER.info("Bajando la Aplicacion [GestPymeSOC]");
    }
	
}
