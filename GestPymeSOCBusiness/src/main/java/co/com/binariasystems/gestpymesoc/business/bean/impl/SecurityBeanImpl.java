package co.com.binariasystems.gestpymesoc.business.bean.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retrofit2.Call;
import retrofit2.Response;
import co.com.binariasystems.fmw.security.FMWSecurityException;
import co.com.binariasystems.fmw.util.exception.FMWExceptionUtils;
import co.com.binariasystems.gestpymesoc.business.bean.ConfigParameterBean;
import co.com.binariasystems.gestpymesoc.business.bean.SecurityBean;
import co.com.binariasystems.orion.model.dto.AccessTokenDTO;
import co.com.binariasystems.orion.model.dto.AuthenticationDTO;
import co.com.binariasystems.orion.model.dto.ResourceDTO;
import co.com.binariasystems.orion.model.dto.RoleDTO;
import co.com.binariasystems.orion.model.dto.UserCredentialsDTO;
import co.com.binariasystems.orion.model.dto.UserDTO;
import co.com.binariasystems.orion.model.enumerated.SN2Boolean;
import co.com.binariasystems.orionclient.ClientBuilder;
import co.com.binariasystems.orionclient.security.SecurityClient;

@Service
public class SecurityBeanImpl implements SecurityBean{
	@Autowired
	private ConfigParameterBean parameterBean;
	private SecurityClient securityClient;
	private ClientBuilder clientBuilder;
	
	@PostConstruct
	protected void init(){
		clientBuilder = ClientBuilder.getInstance(parameterBean.findByConfigParameterCode("URL_CONEXION_ORION").getStringValue(), parameterBean);
		securityClient = clientBuilder.createService(SecurityClient.class);
	}

	@Override
	public UserDTO findUserByLoginAlias(String loginAlias) throws FMWSecurityException {
		Call<UserDTO> serviceCall = securityClient.findUserByLoginAlias(loginAlias);
		try{
			Response<UserDTO> serviceResponse = serviceCall.execute();
			return serviceResponse.body();
		}catch(IOException ex){
			throw new FMWSecurityException(FMWExceptionUtils.prettyMessageException(ex));
		}
	}

	@Override
	public UserCredentialsDTO findUserCredentials(String loginAlias) throws FMWSecurityException {
		Call<UserCredentialsDTO> serviceCall = securityClient.findUserCredentials(loginAlias);
		try{
			Response<UserCredentialsDTO> serviceResponse = serviceCall.execute();
			return serviceResponse.body();
		}catch(IOException ex){
			throw new FMWSecurityException(FMWExceptionUtils.prettyMessageException(ex));
		}
	}

	@Override
	public AccessTokenDTO saveAuthentication(AuthenticationDTO authentication) throws FMWSecurityException {
		Call<AccessTokenDTO> serviceCall = securityClient.saveAuthentication(authentication);
		try{
			Response<AccessTokenDTO> serviceResponse = serviceCall.execute();
			return serviceResponse.body();
		}catch(IOException ex){
			throw new FMWSecurityException(FMWExceptionUtils.prettyMessageException(ex));
		}
	}

	@Override
	public List<RoleDTO> findUserRoles(AuthenticationDTO authentication) throws FMWSecurityException {
		Call<List<RoleDTO>> serviceCall = securityClient.findUserRoles(authentication);
		try{
			Response<List<RoleDTO>> serviceResponse = serviceCall.execute();
			return serviceResponse.body();
		}catch(IOException ex){
			throw new FMWSecurityException(FMWExceptionUtils.prettyMessageException(ex));
		}
	}

	@Override
	public List<ResourceDTO> findRoleResources(RoleDTO role) throws FMWSecurityException {
		Call<List<ResourceDTO>> serviceCall = securityClient.findRoleResources(role);
		try{
			Response<List<ResourceDTO>> serviceResponse = serviceCall.execute();
			return serviceResponse.body();
		}catch(IOException ex){
			throw new FMWSecurityException(FMWExceptionUtils.prettyMessageException(ex));
		}
	}

	@Override
	public boolean validateAccessTokenValidity(AccessTokenDTO accessToken) throws FMWSecurityException {
		Call<SN2Boolean> serviceCall = securityClient.validateAccessTokenValidity(accessToken);
		try{
			Response<SN2Boolean> serviceResponse = serviceCall.execute();
			return serviceResponse.body().booleanValue();
		}catch(IOException ex){
			throw new FMWSecurityException(FMWExceptionUtils.prettyMessageException(ex));
		}
	}

	@Override
	public void invalidateUserSession(AuthenticationDTO authentication) throws FMWSecurityException {
		Call<Void> serviceCall = securityClient.invalidateUserSession(authentication);
		try{
			serviceCall.execute().body();
		}catch(IOException ex){
			throw new FMWSecurityException(FMWExceptionUtils.prettyMessageException(ex));
		}
	}
}
