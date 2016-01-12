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
import javax.validation.constraints.Size;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "MAT_AGRUPADOR_ESTADOS")
@NamedQueries({
    @NamedQuery(name = "MatStateGrouping.findAll", query = "SELECT m FROM MatStateGrouping m")})
public class MatStateGrouping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AGRUPADOR")
    private Integer stateGroupingId;
    @Size(max = 64)
    @Column(name = "COD_AGRUPADOR")
    private String stateGroupingCode;
    @Size(max = 128)
    @Column(name = "NOMBRE")
    private String name;

    /**
     * @return the stateGroupingId
     */
    public Integer getStateGroupingId() {
        return stateGroupingId;
    }

    /**
     * @param stateGroupingId the stateGroupingId to set
     */
    public void setStateGroupingId(Integer stateGroupingId) {
        this.stateGroupingId = stateGroupingId;
    }

    /**
     * @return the stateGroupingCode
     */
    public String getStateGroupingCode() {
        return stateGroupingCode;
    }

    /**
     * @param stateGroupingCode the stateGroupingCode to set
     */
    public void setStateGroupingCode(String stateGroupingCode) {
        this.stateGroupingCode = stateGroupingCode;
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

}
