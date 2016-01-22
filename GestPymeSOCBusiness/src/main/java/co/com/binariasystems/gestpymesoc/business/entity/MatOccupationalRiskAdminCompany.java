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
@Table(name = "MAT_ARLS")
@NamedQueries({
    @NamedQuery(name = "MatOccupationalRiskAdminCompany.findAll", query = "SELECT m FROM MatOccupationalRiskAdminCompany m")})
public class MatOccupationalRiskAdminCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ARL")
    private Integer occupationalRiskAdminCompanyId;
    @Size(max = 15)
    @Column(name = "COD_ARL")
    private String occupationalRiskAdminCompanyCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE")
    private String name;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "ES_VIGENTE")
    private SN2Boolean isActive;

    /**
     * @return the occupationalRiskAdminCompanyId
     */
    public Integer getOccupationalRiskAdminCompanyId() {
        return occupationalRiskAdminCompanyId;
    }

    /**
     * @param occupationalRiskAdminCompanyId the occupationalRiskAdminCompanyId to set
     */
    public void setOccupationalRiskAdminCompanyId(Integer occupationalRiskAdminCompanyId) {
        this.occupationalRiskAdminCompanyId = occupationalRiskAdminCompanyId;
    }

    /**
     * @return the occupationalRiskAdminCompanyCode
     */
    public String getOccupationalRiskAdminCompanyCode() {
        return occupationalRiskAdminCompanyCode;
    }

    /**
     * @param occupationalRiskAdminCompanyCode the occupationalRiskAdminCompanyCode to set
     */
    public void setOccupationalRiskAdminCompanyCode(String occupationalRiskAdminCompanyCode) {
        this.occupationalRiskAdminCompanyCode = occupationalRiskAdminCompanyCode;
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
