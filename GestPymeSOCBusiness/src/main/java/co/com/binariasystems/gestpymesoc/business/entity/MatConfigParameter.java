/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import co.com.binariasystems.gestpymesoc.business.enumerated.Application;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "MAT_PARAMETROS_CONFIG")
@NamedQueries({
    @NamedQuery(name = "MatConfigParameter.findAll", query = "SELECT m FROM MatConfigParameter m")})
public class MatConfigParameter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PARAM_CONFIG")
    private Integer configParameterId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "COD_PARAM_CONFIG")
    private String configParameterCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Enumerated(EnumType.STRING)
    @Column(name = "COD_APLICACION")
    private Application applicationCode;
    @Size(max = 128)
    @Column(name = "DESCRIPCION")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VLR_NUMERICO")
    private Double numericValue;
    @Size(max = 256)
    @Column(name = "VLR_CADENA")
    private String stringValue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_CREACION")
    private String creationUser;
    @Size(max = 30)
    @Column(name = "USUARIO_MODIFICACION")
    private String modificationUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "FEC_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
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
