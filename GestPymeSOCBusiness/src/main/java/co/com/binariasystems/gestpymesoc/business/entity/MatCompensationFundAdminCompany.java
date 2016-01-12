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
@Table(name = "MAT_CCFS")
@NamedQueries({
    @NamedQuery(name = "MatCompensationFundAdminCompany.findAll", query = "SELECT m FROM MatCompensationFundAdminCompany m")})
public class MatCompensationFundAdminCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CCF")
    private Integer compensationFundAdminCompanyId;
    @Size(max = 15)
    @Column(name = "COD_CCF")
    private String compensationFundAdminCompanyCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ES_VIGENTE")
    private String isActive;

    /**
     * @return the compensationFundAdminCompanyId
     */
    public Integer getCompensationFundAdminCompanyId() {
        return compensationFundAdminCompanyId;
    }

    /**
     * @param compensationFundAdminCompanyId the compensationFundAdminCompanyId to set
     */
    public void setCompensationFundAdminCompanyId(Integer compensationFundAdminCompanyId) {
        this.compensationFundAdminCompanyId = compensationFundAdminCompanyId;
    }

    /**
     * @return the compensationFundAdminCompanyCode
     */
    public String getCompensationFundAdminCompanyCode() {
        return compensationFundAdminCompanyCode;
    }

    /**
     * @param compensationFundAdminCompanyCode the compensationFundAdminCompanyCode to set
     */
    public void setCompensationFundAdminCompanyCode(String compensationFundAdminCompanyCode) {
        this.compensationFundAdminCompanyCode = compensationFundAdminCompanyCode;
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
    public String getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
    
}
