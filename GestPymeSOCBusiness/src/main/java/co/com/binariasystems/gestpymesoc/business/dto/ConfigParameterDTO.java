/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.dto;

import java.io.Serializable;
import java.util.Date;

import co.com.binariasystems.gestpymesoc.business.enumerated.Application;

/**
 *
 * @author Alexander
 */
public class ConfigParameterDTO implements Serializable {
    private Integer configParameterId;
    private String configParameterCode;
    private Application applicationCode;
    private String description;
    private Double numericValue;
    private String stringValue;
    private String creationUser;
    private String modificationUser;
    private Date creationDate;
    private Date modificationDate;

    /**
     * @return the configParameterId
     */
    public Integer getConfigParameterId() {
        return configParameterId;
    }

    /**
     * @param configParameterId the configParameterId to set
     */
    public void setConfigParameterId(Integer configParameterId) {
        this.configParameterId = configParameterId;
    }

    /**
     * @return the configParameterCode
     */
    public String getConfigParameterCode() {
        return configParameterCode;
    }

    /**
     * @param configParameterCode the configParameterCode to set
     */
    public void setConfigParameterCode(String configParameterCode) {
        this.configParameterCode = configParameterCode;
    }

    /**
     * @return the applicationCode
     */
    public Application getApplicationCode() {
        return applicationCode;
    }

    /**
     * @param applicationCode the applicationCode to set
     */
    public void setApplicationCode(Application applicationCode) {
        this.applicationCode = applicationCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the numericValue
     */
    public Double getNumericValue() {
        return numericValue;
    }

    /**
     * @param numericValue the numericValue to set
     */
    public void setNumericValue(Double numericValue) {
        this.numericValue = numericValue;
    }

    /**
     * @return the stringValue
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * @param stringValue the stringValue to set
     */
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    /**
     * @return the creationUser
     */
    public String getCreationUser() {
        return creationUser;
    }

    /**
     * @param creationUser the creationUser to set
     */
    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    /**
     * @return the modificationUser
     */
    public String getModificationUser() {
        return modificationUser;
    }

    /**
     * @param modificationUser the modificationUser to set
     */
    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the modificationDate
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * @param modificationDate the modificationDate to set
     */
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
    
}
