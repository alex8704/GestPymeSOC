package co.com.binariasystems.gestpymesoc.business.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.binariasystems.gestpymesoc.business.bean.ConfigParameterBean;
import co.com.binariasystems.gestpymesoc.business.dao.ConfigParameterDAO;
import co.com.binariasystems.gestpymesoc.business.dto.ConfigParameterDTO;
import co.com.binariasystems.orionclient.dto.ClientCredentialsDTO;

@Service
@Transactional
public class ConfigParameterBeanImpl implements ConfigParameterBean{
	@Autowired 
	private ConfigParameterDAO dao;

	public ClientCredentialsDTO getClientCredentials() {
		return new ClientCredentialsDTO("gestpymesoc", "Gana1111");
	}
	
	public ConfigParameterDTO findByConfigParameterCode(String parameterCode){
		ConfigParameterDTO parameter = new ConfigParameterDTO();
		parameter.setStringValue("http://127.0.0.1:8080/OrionSecurityWeb/services/");
		return parameter;
	}
}
