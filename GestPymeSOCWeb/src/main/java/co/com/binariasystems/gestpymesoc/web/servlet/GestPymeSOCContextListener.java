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
import co.com.binariasystems.fmw.util.messagebundle.PropertiesManager;
import co.com.binariasystems.fmw.vweb.constants.VWebCommonConstants;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessUtils;
import co.com.binariasystems.gestpymesoc.web.utils.GPSWebConstants;

/**
 * Application Lifecycle Listener implementation class GestPymeSOCContextListener
 *
 */
public class GestPymeSOCContextListener implements ServletContextListener, GPSWebConstants {
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
    	PropertiesManager properties = PropertiesManager.forPath("/configuration.properties");
    	System.setProperty(GestPymeSOCBusinessConstants.APPLICATION_VERSION_PROPERTY, properties.getString(GestPymeSOCBusinessConstants.APPLICATION_VERSION_PROPERTY));
    	System.setProperty(GestPymeSOCBusinessConstants.APPLICATION_NAME_PROPERTY, properties.getString(GestPymeSOCBusinessConstants.APPLICATION_NAME_PROPERTY));
    	System.setProperty(GestPymeSOCBusinessConstants.MAIN_DATASOURCE_PROPERTY, properties.getString(GestPymeSOCBusinessConstants.MAIN_DATASOURCE_PROPERTY));
    	
    	IOCHelper.setProvider(SpringIOCProvider.configure(WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext())));
    	DBUtil.init(IOCHelper.getBean(GestPymeSOCBusinessUtils.getMainDataSourceName(), DataSource.class));
    	Class resourceLoaderClass = IOCHelper.getBean(FMWConstants.DEFAULT_LOADER_CLASS, Class.class);
    	String entitiesStringsFilePath = IOCHelper.getBean(VWebCommonConstants.APP_ENTITIES_MESSAGES_FILE_IOC_KEY, String.class);
    	String entityOperatiosShowSql = IOCHelper.getBean(FMWEntityConstants.ENTITY_OPERATIONS_SHOWSQL_IOC_KEY, String.class);
    	
    	
    	LOGGER.info(FMWConstants.DEFAULT_LOADER_CLASS + ": " + resourceLoaderClass);
    	LOGGER.info(VWebCommonConstants.APP_ENTITIES_MESSAGES_FILE_IOC_KEY + ": " + entitiesStringsFilePath);
    	LOGGER.info(FMWEntityConstants.ENTITY_OPERATIONS_SHOWSQL_IOC_KEY + ": " + entityOperatiosShowSql);
    	
    	initializeApplication(sce);
    		
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	LOGGER.info("Bajando la Aplicacion [{}]", GestPymeSOCBusinessUtils.getApplicationName());
    }
  
    
    private void initializeApplication(ServletContextEvent sce){
    	
    }
	
}
