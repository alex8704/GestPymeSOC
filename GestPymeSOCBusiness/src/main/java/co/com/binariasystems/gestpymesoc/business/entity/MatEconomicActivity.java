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
@Table(name = "MAT_ACTIVIDADES_ECONOMICAS")
@NamedQueries({
    @NamedQuery(name = "MatEconomicActivity.findAll", query = "SELECT m FROM MatEconomicActivity m")})
public class MatEconomicActivity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ACTIVIDAD_ECONOMICA")
    private Integer economicActivityId;
    @Size(max = 15)
    @Column(name = "COD_ACTIVIDAD_CIIU")
    private String economicActivityCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "NOMBRE")
    private String name;
    @Size(max = 512)
    @Column(name = "DESCRIPCION")
    private String description;
    @JoinColumn(name = "ID_GRUPO_TARIFARIO", referencedColumnName = "ID_GRUPO_TARIFARIO")
    @ManyToOne(optional = false)
    private MatEconomicActivityTariffGrouping tariffGrouping;

    /**
     * @return the economicActivityId
     */
    public Integer getEconomicActivityId() {
        return economicActivityId;
    }

    /**
     * @param economicActivityId the economicActivityId to set
     */
    public void setEconomicActivityId(Integer economicActivityId) {
        this.economicActivityId = economicActivityId;
    }

    /**
     * @return the economicActivityCode
     */
    public String getEconomicActivityCode() {
        return economicActivityCode;
    }

    /**
     * @param economicActivityCode the economicActivityCode to set
     */
    public void setEconomicActivityCode(String economicActivityCode) {
        this.economicActivityCode = economicActivityCode;
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
     * @return the tariffGrouping
     */
    public MatEconomicActivityTariffGrouping getTariffGrouping() {
        return tariffGrouping;
    }

    /**
     * @param tariffGrouping the tariffGrouping to set
     */
    public void setTariffGrouping(MatEconomicActivityTariffGrouping tariffGrouping) {
        this.tariffGrouping = tariffGrouping;
    }
    
}
