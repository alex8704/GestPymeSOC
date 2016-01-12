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
import javax.validation.constraints.Size;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "MAT_DIRECCIONES")
@NamedQueries({
    @NamedQuery(name = "MatAddress.findAll", query = "SELECT m FROM MatAddress m")})
public class MatAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DIRECCION")
    private Integer addressId;
    @Size(max = 15)
    @Column(name = "COD_TIPO_VIA_PPAL")
    private String mainViaTypeCode;
    @Size(max = 3)
    @Column(name = "NUMERO_VIA_PPAL")
    private String mainViaNumber;
    @Size(max = 3)
    @Column(name = "LETRAS_VIA_PPAL")
    private String mainViaLetters;
    @Size(max = 3)
    @Column(name = "BIS")
    private String bis;
    @Size(max = 3)
    @Column(name = "NUMERO_BIS")
    private String bisNumber;
    @Size(max = 3)
    @Column(name = "LETRAS_BIS")
    private String bisLetters;
    @Size(max = 10)
    @Column(name = "CUADRANTE_VIA_PPAL")
    private String mainViaQuadrant;
    @Size(max = 15)
    @Column(name = "COD_COMPLEM_VIA_PPAL")
    private String mainViaComplementCode;
    @Size(max = 40)
    @Column(name = "DETAL_COMPLEM_VIA_PPAL")
    private String mainViaComplementDetail;
    @Size(max = 3)
    @Column(name = "NUMERO_VIA_SECUND")
    private String secondaryViaNumber;
    @Size(max = 3)
    @Column(name = "LETRAS_VIA_SECUND")
    private String secondaryViaLetters;
    @Size(max = 3)
    @Column(name = "NUMERO_VIA_COMPLEM")
    private String complementaryViaNumber;
    @Size(max = 10)
    @Column(name = "CUADRANTE_VIA_COMPLEM")
    private String complementaryViaNumberQuadrant;
    @Size(max = 15)
    @Column(name = "COD_COMPLEM_VIA_COMPLEM")
    private String complementaryViaComplementCode;
    @Size(max = 40)
    @Column(name = "DETAL_COMPLEM_VIA_COMPLEM")
    private String complementaryViaComplementDetail;

    /**
     * @return the addressId
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * @param addressId the addressId to set
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * @return the mainViaTypeCode
     */
    public String getMainViaTypeCode() {
        return mainViaTypeCode;
    }

    /**
     * @param mainViaTypeCode the mainViaTypeCode to set
     */
    public void setMainViaTypeCode(String mainViaTypeCode) {
        this.mainViaTypeCode = mainViaTypeCode;
    }

    /**
     * @return the mainViaNumber
     */
    public String getMainViaNumber() {
        return mainViaNumber;
    }

    /**
     * @param mainViaNumber the mainViaNumber to set
     */
    public void setMainViaNumber(String mainViaNumber) {
        this.mainViaNumber = mainViaNumber;
    }

    /**
     * @return the mainViaLetters
     */
    public String getMainViaLetters() {
        return mainViaLetters;
    }

    /**
     * @param mainViaLetters the mainViaLetters to set
     */
    public void setMainViaLetters(String mainViaLetters) {
        this.mainViaLetters = mainViaLetters;
    }

    /**
     * @return the bis
     */
    public String getBis() {
        return bis;
    }

    /**
     * @param bis the bis to set
     */
    public void setBis(String bis) {
        this.bis = bis;
    }

    /**
     * @return the bisNumber
     */
    public String getBisNumber() {
        return bisNumber;
    }

    /**
     * @param bisNumber the bisNumber to set
     */
    public void setBisNumber(String bisNumber) {
        this.bisNumber = bisNumber;
    }

    /**
     * @return the bisLetters
     */
    public String getBisLetters() {
        return bisLetters;
    }

    /**
     * @param bisLetters the bisLetters to set
     */
    public void setBisLetters(String bisLetters) {
        this.bisLetters = bisLetters;
    }

    /**
     * @return the mainViaQuadrant
     */
    public String getMainViaQuadrant() {
        return mainViaQuadrant;
    }

    /**
     * @param mainViaQuadrant the mainViaQuadrant to set
     */
    public void setMainViaQuadrant(String mainViaQuadrant) {
        this.mainViaQuadrant = mainViaQuadrant;
    }

    /**
     * @return the mainViaComplementCode
     */
    public String getMainViaComplementCode() {
        return mainViaComplementCode;
    }

    /**
     * @param mainViaComplementCode the mainViaComplementCode to set
     */
    public void setMainViaComplementCode(String mainViaComplementCode) {
        this.mainViaComplementCode = mainViaComplementCode;
    }

    /**
     * @return the mainViaComplementDetail
     */
    public String getMainViaComplementDetail() {
        return mainViaComplementDetail;
    }

    /**
     * @param mainViaComplementDetail the mainViaComplementDetail to set
     */
    public void setMainViaComplementDetail(String mainViaComplementDetail) {
        this.mainViaComplementDetail = mainViaComplementDetail;
    }

    /**
     * @return the secondaryViaNumber
     */
    public String getSecondaryViaNumber() {
        return secondaryViaNumber;
    }

    /**
     * @param secondaryViaNumber the secondaryViaNumber to set
     */
    public void setSecondaryViaNumber(String secondaryViaNumber) {
        this.secondaryViaNumber = secondaryViaNumber;
    }

    /**
     * @return the secondaryViaLetters
     */
    public String getSecondaryViaLetters() {
        return secondaryViaLetters;
    }

    /**
     * @param secondaryViaLetters the secondaryViaLetters to set
     */
    public void setSecondaryViaLetters(String secondaryViaLetters) {
        this.secondaryViaLetters = secondaryViaLetters;
    }

    /**
     * @return the complementaryViaNumber
     */
    public String getComplementaryViaNumber() {
        return complementaryViaNumber;
    }

    /**
     * @param complementaryViaNumber the complementaryViaNumber to set
     */
    public void setComplementaryViaNumber(String complementaryViaNumber) {
        this.complementaryViaNumber = complementaryViaNumber;
    }

    /**
     * @return the complementaryViaNumberQuadrant
     */
    public String getComplementaryViaNumberQuadrant() {
        return complementaryViaNumberQuadrant;
    }

    /**
     * @param complementaryViaNumberQuadrant the complementaryViaNumberQuadrant to set
     */
    public void setComplementaryViaNumberQuadrant(String complementaryViaNumberQuadrant) {
        this.complementaryViaNumberQuadrant = complementaryViaNumberQuadrant;
    }

    /**
     * @return the complementaryViaComplementCode
     */
    public String getComplementaryViaComplementCode() {
        return complementaryViaComplementCode;
    }

    /**
     * @param complementaryViaComplementCode the complementaryViaComplementCode to set
     */
    public void setComplementaryViaComplementCode(String complementaryViaComplementCode) {
        this.complementaryViaComplementCode = complementaryViaComplementCode;
    }

    /**
     * @return the complementaryViaComplementDetail
     */
    public String getComplementaryViaComplementDetail() {
        return complementaryViaComplementDetail;
    }

    /**
     * @param complementaryViaComplementDetail the complementaryViaComplementDetail to set
     */
    public void setComplementaryViaComplementDetail(String complementaryViaComplementDetail) {
        this.complementaryViaComplementDetail = complementaryViaComplementDetail;
    }

}
