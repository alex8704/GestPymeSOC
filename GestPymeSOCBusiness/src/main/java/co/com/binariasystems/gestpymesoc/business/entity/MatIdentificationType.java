/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "MAT_TIPOS_IDENTIFICACION")
@NamedQueries({
    @NamedQuery(name = "MatIdentificationType.findAll", query = "SELECT m FROM MatIdentificationType m")})
public class MatIdentificationType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_IDENTIFICACION")
    private Integer identificationTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_TIPO_IDENTIFICACION")
    private String identificationTypeCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NOMBRE_CORTO")
    private String shorName;
    @Size(max = 128)
    @Column(name = "DESCRIPCION")
    private String description;

    /**
     * @return the identificationTypeId
     */
    public Integer getIdentificationTypeId() {
        return identificationTypeId;
    }

    /**
     * @param identificationTypeId the identificationTypeId to set
     */
    public void setIdentificationTypeId(Integer identificationTypeId) {
        this.identificationTypeId = identificationTypeId;
    }

    /**
     * @return the identificationTypeCode
     */
    public String getIdentificationTypeCode() {
        return identificationTypeCode;
    }

    /**
     * @param identificationTypeCode the identificationTypeCode to set
     */
    public void setIdentificationTypeCode(String identificationTypeCode) {
        this.identificationTypeCode = identificationTypeCode;
    }

    /**
     * @return the shorName
     */
    public String getShorName() {
        return shorName;
    }

    /**
     * @param shorName the shorName to set
     */
    public void setShorName(String shorName) {
        this.shorName = shorName;
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
}
