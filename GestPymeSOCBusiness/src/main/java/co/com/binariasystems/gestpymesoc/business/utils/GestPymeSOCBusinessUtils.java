package co.com.binariasystems.gestpymesoc.business.utils;

import co.com.binariasystems.commonsmodel.constants.SystemConstants;
import co.com.binariasystems.fmw.constants.FMWConstants;
import co.com.binariasystems.fmw.ioc.IOCHelper;
import co.com.binariasystems.fmw.util.messagebundle.PropertiesManager;

public class GestPymeSOCBusinessUtils implements GestPymeSOCBusinessConstants, SystemConstants {
	private static PropertiesManager configProperties;
	public static String getApplicationName(){
		return getConfigProperties().getString(APP_NAME_PROP);
	}
	
	public static String getApplicationVersion(){
		return getConfigProperties().getString(APP_VERSION_PROP);
	}
	
	public static String getMainDataSourceName(){
		return getConfigProperties().getString(MAIN_DSOURCE_PROP);
	}
	
	public static PropertiesManager getConfigProperties(){
		if(configProperties == null){
			configProperties = PropertiesManager.forPath("/configuration.properties", false, IOCHelper.getBean(FMWConstants.DEFAULT_LOADER_CLASS, Class.class));
		}
		return configProperties;
	}
}
