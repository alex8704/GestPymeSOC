/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import co.com.binariasystems.gestpymesoc.business.enumerated.PersonType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "MAT_TERCEROS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "SUBTYPE_DISCRIMINATOR", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("TERCERO")
@NamedQueries({
    @NamedQuery(name = "MatThirdPerson.findAll", query = "SELECT m FROM MatThirdPerson m")})
public class MatThirdPerson implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TERCERO")
    private Integer thirdPersonId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NUM_TELEFONO1")
    private String phoneNumber1;
    @Size(max = 15)
    @Column(name = "NUM_TELEFONO2")
    private String phoneNumber2;
    @Size(max = 64)
    @Enumerated(EnumType.STRING)
    @Column(name = "COD_TIPO_PERSONA")
    private PersonType personType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NUM_IDENTIFICACION")
    private String identificationNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "RAZON_SOCIAL")
    private String businessName;
    @Size(max = 128)
    @Column(name = "PRIMER_NOMBRE")
    private String firstName;
    @Size(max = 128)
    @Column(name = "SEGUNDO_NOMBRE")
    private String middleName;
    @Size(max = 128)
    @Column(name = "PRIMER_APELLIDO")
    private String lastName;
    @Size(max = 128)
    @Column(name = "SEGUNDO_APELLIDO")
    private String secondLasName;
    @Size(max = 256)
    @Column(name = "CORREO_ELECTRONICO")
    private String emailAddress;
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
    @JoinColumn(name = "ID_TIPO_IDENTIFICACION", referencedColumnName = "ID_TIPO_IDENTIFICACION")
    @ManyToOne(optional = false)
    private MatIdentificationType identificationType;
    @JoinColumn(name = "ID_TIPO_CONTRIBUYENTE", referencedColumnName = "ID_TIPO_CONTRIBUYENTE")
    @ManyToOne(optional = false)
    private MatTaxpayerType taxpayerType;
    @JoinColumn(name = "ID_DIRECCION", referencedColumnName = "ID_DIRECCION")
    @ManyToOne
    private MatAddress address;
    @JoinColumn(name = "ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private MatCity city;
    @JoinColumn(name = "ID_ACTIVIDAD_ECONOMICA", referencedColumnName = "ID_ACTIVIDAD_ECONOMICA")
    @ManyToOne
    private MatEconomicActivity economicActivity;

    /**
     * @return the thirdPersonId
     */
    public Integer getThirdPersonId() {
        return thirdPersonId;
    }

    /**
     * @param thirdPersonId the thirdPersonId to set
     */
    public void setThirdPersonId(Integer thirdPersonId) {
        this.thirdPersonId = thirdPersonId;
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
     * @return the identificationNumber
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * @param identificationNumber the identificationNumber to set
     */
    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the secondLasName
     */
    public String getSecondLasName() {
        return secondLasName;
    }

    /**
     * @param secondLasName the secondLasName to set
     */
    public void setSecondLasName(String secondLasName) {
        this.secondLasName = secondLasName;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
     * @return the identificationType
     */
    public MatIdentificationType getIdentificationType() {
        return identificationType;
    }

    /**
     * @param identificationType the identificationType to set
     */
    public void setIdentificationType(MatIdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    /**
     * @return the taxpayerType
     */
    public MatTaxpayerType getTaxpayerType() {
        return taxpayerType;
    }

    /**
     * @param taxpayerType the taxpayerType to set
     */
    public void setTaxpayerType(MatTaxpayerType taxpayerType) {
        this.taxpayerType = taxpayerType;
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

    /**
     * @return the economicActivity
     */
    public MatEconomicActivity getEconomicActivity() {
        return economicActivity;
    }

    /**
     * @param economicActivity the economicActivity to set
     */
    public void setEconomicActivity(MatEconomicActivity economicActivity) {
        this.economicActivity = economicActivity;
    }

}
