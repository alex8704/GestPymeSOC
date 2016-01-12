package co.com.binariasystems.gestpymesoc.business.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.binariasystems.fmw.business.FMWBusiness;
import co.com.binariasystems.gestpymesoc.business.dao.ConfigParameterDAO;

@Service
@Transactional
public class ConfigParameterBean implements FMWBusiness {
	@Autowired 
	private ConfigParameterDAO dao;
	
}
