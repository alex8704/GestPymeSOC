package co.com.binariasystems.gestpymesoc.web.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import co.com.binariasystems.fmw.constants.FMWConstants;
import co.com.binariasystems.fmw.entity.util.FMWEntityConstants;
import co.com.binariasystems.fmw.ioc.IOCHelper;
import co.com.binariasystems.fmw.util.db.DBUtil;
import co.com.binariasystems.fmw.util.di.SpringIOCProvider;
import co.com.binariasystems.fmw.util.messagebundle.MessageBundleManager;
import co.com.binariasystems.fmw.vweb.constants.VWebCommonConstants;
import co.com.binariasystems.gestpymesoc.business.bean.GestPymeSOCSystemBean;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessUtils;
import co.com.binariasystems.gestpymesoc.web.resources.resources;
import co.com.binariasystems.gestpymesoc.web.utils.GPSWebConstants;

/**
 * Application Lifecycle Listener implementation class GestPymeSOCContextListener
 *
 */
public class GestPymeSOCContextListener implements ServletContextListener, GPSWebConstants {
	private static final Logger LOGGER = LoggerFactory.getLogger(GestPymeSOCContextListener.class);
	private static final String PARAM_CREATE_DATAMODEL = GestPymeSOCContextListener.class.getSimpleName()+".createDataModelIfNotExist";
    /**
     * Default constructor. 
     */
    public GestPymeSOCContextListener() {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	MessageBundleManager messages = MessageBundleManager.forPath(resources.getMessageFilePath(MAIN_MESSAGES_FILE));
    	String appVersion = sce.getServletContext().getInitParameter(GestPymeSOCBusinessConstants.APPLICATION_VERSION_PROPERTY);
    	System.setProperty(GestPymeSOCBusinessConstants.APPLICATION_VERSION_PROPERTY, appVersion);
    	System.setProperty(GestPymeSOCBusinessConstants.APPLICATION_NAME_PROPERTY, messages.getString(GestPymeSOCBusinessConstants.APPLICATION_NAME_PROPERTY));
    	
    	IOCHelper.setProvider(SpringIOCProvider.configure(WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext())));
    	DBUtil.init(IOCHelper.getBean("GestPymeSOCDS", DataSource.class));
    	Class resourceLoaderClass = IOCHelper.getBean(FMWConstants.APPLICATION_DEFAULT_CLASS_FOR_RESOURCE_LOAD_IOC_KEY, Class.class);
    	String entitiesStringsFilePath = IOCHelper.getBean(VWebCommonConstants.APP_ENTITIES_MESSAGES_FILE_IOC_KEY, String.class);
    	String entityOperatiosShowSql = IOCHelper.getBean(FMWEntityConstants.ENTITY_OPERATIONS_SHOWSQL_IOC_KEY, String.class);
    	
    	
    	LOGGER.info(FMWConstants.APPLICATION_DEFAULT_CLASS_FOR_RESOURCE_LOAD_IOC_KEY + ": " + resourceLoaderClass);
    	LOGGER.info(VWebCommonConstants.APP_ENTITIES_MESSAGES_FILE_IOC_KEY + ": " + entitiesStringsFilePath);
    	LOGGER.info(FMWEntityConstants.ENTITY_OPERATIONS_SHOWSQL_IOC_KEY + ": " + entityOperatiosShowSql);
    	
    	if(isDataModelCreated(sce)){
    		initializeApplication(sce);
    	}
    		
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	LOGGER.info("Bajando la Aplicacion [{}]", GestPymeSOCBusinessUtils.getApplicationName());
    }
    
    private boolean isDataModelCreated(ServletContextEvent sce){
    	GestPymeSOCSystemBean systemBean = IOCHelper.getBean(GestPymeSOCSystemBean.class);
    	return systemBean.validateDataModelCreation(Boolean.valueOf(StringUtils.defaultIfBlank(sce.getServletContext().getInitParameter(PARAM_CREATE_DATAMODEL), "false")));
    }
    
    private void initializeApplication(ServletContextEvent sce){
    	
    }
	
}
