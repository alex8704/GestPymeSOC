package co.com.binariasystems.gestpymesoc.business.utils;

import co.com.binariasystems.commonsmodel.constants.SystemConstants;

public class GestPymeSOCBusinessUtils implements GestPymeSOCBusinessConstants, SystemConstants {
	public static String getApplicationName(){
		return System.getProperty(APP_NAME_PROP);
	}
	
	public static String getApplicationVersion(){
		return System.getProperty(APP_VERSION_PROP);
	}
	
	public static String getMainDataSourceName(){
		return System.getProperty(MAIN_DSOURCE_PROP);
	}
}
