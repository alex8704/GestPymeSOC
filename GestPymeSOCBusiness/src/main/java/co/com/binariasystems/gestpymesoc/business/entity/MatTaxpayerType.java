/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import co.com.binariasystems.gestpymesoc.business.enumerated.SN2Boolean;
import java.io.Serializable;
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
@Table(name = "MAT_TIPOS_CONTRIBUYENTE")
@NamedQueries({
    @NamedQuery(name = "MatTaxpayerType.findAll", query = "SELECT m FROM MatTaxpayerType m")})
public class MatTaxpayerType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_CONTRIBUYENTE")
    private Integer taxpayerTypeId;
    @Size(max = 15)
    @Column(name = "COD_TIPO_CONTRIBUYENTE")
    private String taxpayerTypeCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE")
    private String name;
    @Size(max = 128)
    @Column(name = "DESCRIPCION")
    private String description;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "RETEFUENTE_RENTA_APLICABLE")
    private SN2Boolean isIncomeRetentionTarget;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "RETEFUENTE_IVA_APLICABLE")
    private SN2Boolean isIVARetentionTarget;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "RETEFUENTE_ICA_APLICABLE")
    private SN2Boolean isICARetentionTarget;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "RETEFUENTE_CRE_APLICABLE")
    private SN2Boolean isCREERetentionTarget;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "DECLARA_IVA")
    private SN2Boolean responsibleOfIVA;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "DECLARA_RENTA")
    private SN2Boolean responsibleOfIncome;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "DECLARA_ICA")
    private SN2Boolean responsibleOfICA;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "DECLARA_CREE")
    private SN2Boolean responsibleOfCREE;
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
     * @return the taxpayerTypeId
     */
    public Integer getTaxpayerTypeId() {
        return taxpayerTypeId;
    }

    /**
     * @param taxpayerTypeId the taxpayerTypeId to set
     */
    public void setTaxpayerTypeId(Integer taxpayerTypeId) {
        this.taxpayerTypeId = taxpayerTypeId;
    }

    /**
     * @return the taxpayerTypeCode
     */
    public String getTaxpayerTypeCode() {
        return taxpayerTypeCode;
    }

    /**
     * @param taxpayerTypeCode the taxpayerTypeCode to set
     */
    public void setTaxpayerTypeCode(String taxpayerTypeCode) {
        this.taxpayerTypeCode = taxpayerTypeCode;
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
     * @return the isIncomeRetentionTarget
     */
    public SN2Boolean getIsIncomeRetentionTarget() {
        return isIncomeRetentionTarget;
    }

    /**
     * @param isIncomeRetentionTarget the isIncomeRetentionTarget to set
     */
    public void setIsIncomeRetentionTarget(SN2Boolean isIncomeRetentionTarget) {
        this.isIncomeRetentionTarget = isIncomeRetentionTarget;
    }

    /**
     * @return the isIVARetentionTarget
     */
    public SN2Boolean getIsIVARetentionTarget() {
        return isIVARetentionTarget;
    }

    /**
     * @param isIVARetentionTarget the isIVARetentionTarget to set
     */
    public void setIsIVARetentionTarget(SN2Boolean isIVARetentionTarget) {
        this.isIVARetentionTarget = isIVARetentionTarget;
    }

    /**
     * @return the isICARetentionTarget
     */
    public SN2Boolean getIsICARetentionTarget() {
        return isICARetentionTarget;
    }

    /**
     * @param isICARetentionTarget the isICARetentionTarget to set
     */
    public void setIsICARetentionTarget(SN2Boolean isICARetentionTarget) {
        this.isICARetentionTarget = isICARetentionTarget;
    }

    /**
     * @return the isCREERetentionTarget
     */
    public SN2Boolean getIsCREERetentionTarget() {
        return isCREERetentionTarget;
    }

    /**
     * @param isCREERetentionTarget the isCREERetentionTarget to set
     */
    public void setIsCREERetentionTarget(SN2Boolean isCREERetentionTarget) {
        this.isCREERetentionTarget = isCREERetentionTarget;
    }

    /**
     * @return the responsibleOfIVA
     */
    public SN2Boolean getResponsibleOfIVA() {
        return responsibleOfIVA;
    }

    /**
     * @param responsibleOfIVA the responsibleOfIVA to set
     */
    public void setResponsibleOfIVA(SN2Boolean responsibleOfIVA) {
        this.responsibleOfIVA = responsibleOfIVA;
    }

    /**
     * @return the responsibleOfIncome
     */
    public SN2Boolean getResponsibleOfIncome() {
        return responsibleOfIncome;
    }

    /**
     * @param responsibleOfIncome the responsibleOfIncome to set
     */
    public void setResponsibleOfIncome(SN2Boolean responsibleOfIncome) {
        this.responsibleOfIncome = responsibleOfIncome;
    }

    /**
     * @return the responsibleOfICA
     */
    public SN2Boolean getResponsibleOfICA() {
        return responsibleOfICA;
    }

    /**
     * @param responsibleOfICA the responsibleOfICA to set
     */
    public void setResponsibleOfICA(SN2Boolean responsibleOfICA) {
        this.responsibleOfICA = responsibleOfICA;
    }

    /**
     * @return the responsibleOfCREE
     */
    public SN2Boolean getResponsibleOfCREE() {
        return responsibleOfCREE;
    }

    /**
     * @param responsibleOfCREE the responsibleOfCREE to set
     */
    public void setResponsibleOfCREE(SN2Boolean responsibleOfCREE) {
        this.responsibleOfCREE = responsibleOfCREE;
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
