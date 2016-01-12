/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import co.com.binariasystems.gestpymesoc.business.enumerated.SN2Boolean;
import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "MAT_AFPS")
@NamedQueries({
    @NamedQuery(name = "MatPensionFundAdminCompany.findAll", query = "SELECT m FROM MatPensionFundAdminCompany m")})
public class MatPensionFundAdminCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AFP")
    private Integer pensionFundAdminCompanyId;
    @Size(max = 15)
    @Column(name = "COD_AFP")
    private String pensionFundAdminCompanyCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Enumerated(EnumType.STRING)
    @Column(name = "ES_VIGENTE")
    private SN2Boolean isActive;

    /**
     * @return the pensionFundAdminCompanyId
     */
    public Integer getPensionFundAdminCompanyId() {
        return pensionFundAdminCompanyId;
    }

    /**
     * @param pensionFundAdminCompanyId the pensionFundAdminCompanyId to set
     */
    public void setPensionFundAdminCompanyId(Integer pensionFundAdminCompanyId) {
        this.pensionFundAdminCompanyId = pensionFundAdminCompanyId;
    }

    /**
     * @return the pensionFundAdminCompanyCode
     */
    public String getPensionFundAdminCompanyCode() {
        return pensionFundAdminCompanyCode;
    }

    /**
     * @param pensionFundAdminCompanyCode the pensionFundAdminCompanyCode to set
     */
    public void setPensionFundAdminCompanyCode(String pensionFundAdminCompanyCode) {
        this.pensionFundAdminCompanyCode = pensionFundAdminCompanyCode;
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
     * @return the isActive
     */
    public SN2Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(SN2Boolean isActive) {
        this.isActive = isActive;
    }
}
