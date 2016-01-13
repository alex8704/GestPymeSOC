package co.com.binariasystems.gestpymesoc.business.dao;

import static co.com.binariasystems.gestpymesoc.business.resources.resources.getPropertyFilePath;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import co.com.binariasystems.fmw.dataaccess.db.FMWAbstractDAO;

@Repository
public class GestPymeSOCSystemDAO extends FMWAbstractDAO{
	private static final Logger LOGGER = LoggerFactory.getLogger(GestPymeSOCSystemDAO.class);
	private RowCallbackHandler dbValidationCallback;
	@Qualifier("jdbcTemplate")
	@Autowired
	public void setTemplate(JdbcTemplate jdbcTemplate){
		setJdbcTemplate(jdbcTemplate);
	}
	
	@PostConstruct
	protected void init(){
		setMessagesFilePath(getPropertyFilePath(new StringBuilder(getClass().getSimpleName()).append("_SQL.xml").toString()));
		ensureMessageBundle();
		
		dbValidationCallback = new RowCallbackHandler() {
			@Override public void processRow(ResultSet rs) throws SQLException {
				LOGGER.info("GestPymeSOC DataBase Validation Sucessfull finished. Dummy Value: '{}'", rs.getString(1));
			}
		};
	}
	
	public boolean validateDataModelCreation(){
		if(getDataSource() == null) return true;//Responde True para evitar interpretar error de conexion con NO creacionde BD
		String sqlStmt = getString(new StringBuilder(getClass().getSimpleName()).append(".").append("validateDatabaseCreation").toString());
		try {
			getJdbcTemplate().query(sqlStmt, dbValidationCallback);
			return true;
		} catch (DataAccessException e) {
			return false;
		}
	}
	
	public boolean isSuperAdminConfigured(){
		return true;
	}
}
