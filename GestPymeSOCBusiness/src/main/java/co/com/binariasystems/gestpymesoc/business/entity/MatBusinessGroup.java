/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MAT_GRUPOS_EMPRESARIALES")
@NamedQueries({
    @NamedQuery(name = "MatBusinessGroup.findAll", query = "SELECT m FROM MatBusinessGroup m")})
public class MatBusinessGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_GRUPO_EMPRESARIAL")
    private Integer businessGroupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "RAZON_SOCIAL")
    private String businessName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDENTIFICACION_TRIBUTARIA")
    private String taxIdentification;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DIGITO_VERIFICACION")
    private String checkDigit;
    @Size(max = 15)
    @Column(name = "NUM_PBX")
    private String pbxNumber;
    @Size(max = 15)
    @Column(name = "NUM_TELEFONO1")
    private String phoneNumber1;
    @Size(max = 15)
    @Column(name = "NUM_TELEFONO2")
    private String phoneNumber2;
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
    @JoinColumn(name = "ID_DIRECCION", referencedColumnName = "ID_DIRECCION")
    @ManyToOne
    private MatAddress address;
    @JoinColumn(name = "ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private MatCity city;

    /**
     * @return the businessGroupId
     */
    public Integer getBusinessGroupId() {
        return businessGroupId;
    }

    /**
     * @param businessGroupId the businessGroupId to set
     */
    public void setBusinessGroupId(Integer businessGroupId) {
        this.businessGroupId = businessGroupId;
    }

    /**
     * @return the businessName
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * @param businessName the businessName to set
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * @return the taxIdentification
     */
    public String getTaxIdentification() {
        return taxIdentification;
    }

    /**
     * @param taxIdentification the taxIdentification to set
     */
    public void setTaxIdentification(String taxIdentification) {
        this.taxIdentification = taxIdentification;
    }

    /**
     * @return the checkDigit
     */
    public String getCheckDigit() {
        return checkDigit;
    }

    /**
     * @param checkDigit the checkDigit to set
     */
    public void setCheckDigit(String checkDigit) {
        this.checkDigit = checkDigit;
    }

    /**
     * @return the pbxNumber
     */
    public String getPbxNumber() {
        return pbxNumber;
    }

    /**
     * @param pbxNumber the pbxNumber to set
     */
    public void setPbxNumber(String pbxNumber) {
        this.pbxNumber = pbxNumber;
    }

    /**
     * @return the phoneNumber1
     */
    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    /**
     * @param phoneNumber1 the phoneNumber1 to set
     */
    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    /**
     * @return the phoneNumber2
     */
    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    /**
     * @param phoneNumber2 the phoneNumber2 to set
     */
    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
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
     * @return the address
     */
    public MatAddress getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(MatAddress address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public MatCity getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(MatCity city) {
        this.city = city;
    }

}
