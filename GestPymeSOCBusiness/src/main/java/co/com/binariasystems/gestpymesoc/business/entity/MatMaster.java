/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "MAT_MAESTRAS")
@NamedQueries({
    @NamedQuery(name = "MatMaster.findAll", query = "SELECT m FROM MatMaster m")})
public class MatMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MAESTRA")
    private Integer masterId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_MAESTRA")
    private String masterCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "master")
    private List<MatMasterData> matMasterDataList;

    /**
     * @return the masterId
     */
    public Integer getMasterId() {
        return masterId;
    }

    /**
     * @param masterId the masterId to set
     */
    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    /**
     * @return the masterCode
     */
    public String getMasterCode() {
        return masterCode;
    }

    /**
     * @param masterCode the masterCode to set
     */
    public void setMasterCode(String masterCode) {
        this.masterCode = masterCode;
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
     * @return the matMasterDataList
     */
    public List<MatMasterData> getMatMasterDataList() {
        return matMasterDataList;
    }

    /**
     * @param matMasterDataList the matMasterDataList to set
     */
    public void setMatMasterDataList(List<MatMasterData> matMasterDataList) {
        this.matMasterDataList = matMasterDataList;
    }
    
}
