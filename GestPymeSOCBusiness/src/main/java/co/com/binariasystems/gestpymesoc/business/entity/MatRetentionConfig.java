/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import co.com.binariasystems.gestpymesoc.business.enumerated.PersonType;
import co.com.binariasystems.gestpymesoc.business.enumerated.RetentionTaxtType;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MAT_CONFIG_RETENCIONES")
@NamedQueries({
    @NamedQuery(name = "MatRetentionConfig.findAll", query = "SELECT m FROM MatRetentionConfig m")})
public class MatRetentionConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONFIG_RETENCION")
    private Integer retentionConfigId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Enumerated(EnumType.STRING)
    @Column(name = "COD_TIPO_RETENCION")
    private RetentionTaxtType retentionTaxtType;
    @Size(max = 64)
    @Enumerated(EnumType.STRING)
    @Column(name = "COD_TIPO_PERSONA")
    private PersonType personType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "UVT_GRAVABLE")
    private Double taxableUVT;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR_TARIFA")
    private Double tariffValue;
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
    @JoinColumn(name = "ID_CONCEPTO_PAGO", referencedColumnName = "ID_CONCEPTO_PAGO")
    @ManyToOne(optional = false)
    private MatPaymentConcept paymentConcept;

    /**
     * @return the retentionConfigId
     */
    public Integer getRetentionConfigId() {
        return retentionConfigId;
    }

    /**
     * @param retentionConfigId the retentionConfigId to set
     */
    public void setRetentionConfigId(Integer retentionConfigId) {
        this.retentionConfigId = retentionConfigId;
    }

    /**
     * @return the retentionTaxtType
     */
    public RetentionTaxtType getRetentionTaxtType() {
        return retentionTaxtType;
    }

    /**
     * @param retentionTaxtType the retentionTaxtType to set
     */
    public void setRetentionTaxtType(RetentionTaxtType retentionTaxtType) {
        this.retentionTaxtType = retentionTaxtType;
    }

    /**
     * @return the personType
     */
    public PersonType getPersonType() {
        return personType;
    }

    /**
     * @param personType the personType to set
     */
    public void setPersonType(PersonType personType) {
        this.personType = personType;
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
     * @return the tariffValue
     */
    public Double getTariffValue() {
        return tariffValue;
    }

    /**
     * @param tariffValue the tariffValue to set
     */
    public void setTariffValue(Double tariffValue) {
        this.tariffValue = tariffValue;
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

    /**
     * @return the paymentConcept
     */
    public MatPaymentConcept getPaymentConcept() {
        return paymentConcept;
    }

    /**
     * @param paymentConcept the paymentConcept to set
     */
    public void setPaymentConcept(MatPaymentConcept paymentConcept) {
        this.paymentConcept = paymentConcept;
    }

}
