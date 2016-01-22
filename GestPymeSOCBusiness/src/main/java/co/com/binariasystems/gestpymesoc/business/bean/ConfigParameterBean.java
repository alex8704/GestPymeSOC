package co.com.binariasystems.gestpymesoc.business.bean;

import co.com.binariasystems.fmw.business.FMWBusiness;
import co.com.binariasystems.gestpymesoc.business.dto.ConfigParameterDTO;
import co.com.binariasystems.orionclient.ClientCredentialsProvider;


public interface ConfigParameterBean extends FMWBusiness, ClientCredentialsProvider {
	public ConfigParameterDTO findByConfigParameterCode(String parameterCode);
}
