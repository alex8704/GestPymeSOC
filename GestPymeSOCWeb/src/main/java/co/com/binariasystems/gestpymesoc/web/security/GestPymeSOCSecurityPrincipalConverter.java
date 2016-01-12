package co.com.binariasystems.gestpymesoc.web.security;

import co.com.binariasystems.fmw.security.FMWSecurityException;
import co.com.binariasystems.fmw.security.authc.SecurityPrincipalConverter;

public class GestPymeSOCSecurityPrincipalConverter implements SecurityPrincipalConverter<String, Object> {

	@Override
	public Object toPrincipalModel(String representation) throws FMWSecurityException {
		return representation;
	}

	@Override
	public String toPrincipalRepresentation(Object model) throws FMWSecurityException {
		return model.toString();
	}

}
