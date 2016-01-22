/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import co.com.binariasystems.gestpymesoc.business.enumerated.EconomicCategory;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "MAT_GRUPOS_TARIFA_ACTI_ECONOM")
@NamedQueries({
    @NamedQuery(name = "MatEconomicActivityTariffGrouping.findAll", query = "SELECT m FROM MatEconomicActivityTariffGrouping m")})
public class MatEconomicActivityTariffGrouping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_GRUPO_TARIFARIO")
    private Integer tariffGroupingId;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "COD_RUBRO_ECONOMICO")
    private EconomicCategory economicCategory;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_GRUPO_TARIFARIO")
    private String tariffGroupingCode;
    @Size(max = 256)
    @Column(name = "NOMBRE")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UVT_GRAVABLE")
    private Double taxableUVT;
    @Column(name = "VLR_TARIFA_X_MIL_VIGENTE")
    private Double currentTariffValue;
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
     * @return the tariffGroupingId
     */
    public Integer getTariffGroupingId() {
        return tariffGroupingId;
    }

    /**
     * @param tariffGroupingId the tariffGroupingId to set
     */
    public void setTariffGroupingId(Integer tariffGroupingId) {
        this.tariffGroupingId = tariffGroupingId;
    }

    /**
     * @return the economicCategory
     */
    public EconomicCategory getEconomicCategory() {
        return economicCategory;
    }

    /**
     * @param economicCategory the economicCategory to set
     */
    public void setEconomicCategory(EconomicCategory economicCategory) {
        this.economicCategory = economicCategory;
    }

    /**
     * @return the tariffGroupingCode
     */
    public String getTariffGroupingCode() {
        return tariffGroupingCode;
    }

    /**
     * @param tariffGroupingCode the tariffGroupingCode to set
     */
    public void setTariffGroupingCode(String tariffGroupingCode) {
        this.tariffGroupingCode = tariffGroupingCode;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the taxableUVT
     */
    public Double getTaxableUVT() {
        return taxableUVT;
    }

    /**
     * @param taxableUVT the taxableUVT to set
     */
    public void setTaxableUVT(Double taxableUVT) {
        this.taxableUVT = taxableUVT;
    }

    /**
     * @return the currentTariffValue
     */
    public Double getCurrentTariffValue() {
        return currentTariffValue;
    }

    /**
     * @param currentTariffValue the currentTariffValue to set
     */
    public void setCurrentTariffValue(Double currentTariffValue) {
        this.currentTariffValue = currentTariffValue;
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
