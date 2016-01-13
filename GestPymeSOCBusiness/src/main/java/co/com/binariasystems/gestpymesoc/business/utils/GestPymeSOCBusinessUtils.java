package co.com.binariasystems.gestpymesoc.business.utils;

public class GestPymeSOCBusinessUtils implements GestPymeSOCBusinessConstants {
	public static String getApplicationName(){
		return System.getProperty(APPLICATION_NAME_PROPERTY);
	}
	
	public static String getApplicationVersion(){
		return System.getProperty(APPLICATION_VERSION_PROPERTY);
	}
}
