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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MAT_DATOS_MAESTRAS")
@NamedQueries({
    @NamedQuery(name = "MatMasterData.findAll", query = "SELECT m FROM MatMasterData m")})
public class MatMasterData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DATO_MAESTRA")
    private Integer masterDataId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_DATO_MAESTRA")
    private String masterDataCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "DESCRIPCION")
    private String description;
    @JoinColumn(name = "ID_MAESTRA", referencedColumnName = "ID_MAESTRA")
    @ManyToOne(optional = false)
    private MatMaster master;

    /**
     * @return the masterDataId
     */
    public Integer getMasterDataId() {
        return masterDataId;
    }

    /**
     * @param masterDataId the masterDataId to set
     */
    public void setMasterDataId(Integer masterDataId) {
        this.masterDataId = masterDataId;
    }

    /**
     * @return the masterDataCode
     */
    public String getMasterDataCode() {
        return masterDataCode;
    }

    /**
     * @param masterDataCode the masterDataCode to set
     */
    public void setMasterDataCode(String masterDataCode) {
        this.masterDataCode = masterDataCode;
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
     * @return the master
     */
    public MatMaster getMaster() {
        return master;
    }

    /**
     * @param master the master to set
     */
    public void setMaster(MatMaster master) {
        this.master = master;
    }
}
