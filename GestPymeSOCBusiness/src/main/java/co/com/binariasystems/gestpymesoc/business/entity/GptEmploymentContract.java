/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import co.com.binariasystems.gestpymesoc.business.enumerated.ContractTermType;
import co.com.binariasystems.gestpymesoc.business.enumerated.SN2Boolean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "GPT_CONTRATOS_LABORALES")
@NamedQueries({
    @NamedQuery(name = "GptEmploymentContract.findAll", query = "SELECT g FROM GptEmploymentContract g")})
public class GptEmploymentContract implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONTRATO")
    private Integer employmentContractId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR_SALARIO_BASE")
    private Double baseSalaryValue;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "ES_VIGENTE")
    private SN2Boolean isCurrent;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "ES_SALARIO_INTEGRAL")
    private SN2Boolean isFullSalary;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "DERECHO_RECARGOS")
    private SN2Boolean haveSurcharge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_INICIO")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "FEC_TERMINACION")
    @Temporal(TemporalType.DATE)
    private Date terminationDate;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "COD_TIPO_TERMINO")
    private ContractTermType termType;
    @Size(max = 1)
    @Enumerated(EnumType.STRING)
    @Column(name = "REPORTA_TIEMPO")
    private SN2Boolean mustReportWorkTime;
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
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_TERCERO")
    @ManyToOne(optional = false)
    private GptEmployee employee;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private MatCompany company;
    @JoinColumn(name = "ID_MOTIVO_TERMINACION", referencedColumnName = "ID_MOTIVO_TERMINACION")
    @ManyToOne
    private GptContractTerminationReason terminationReason;
    @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID_CARGO")
    @ManyToOne(optional = false)
    private GptAppointment appointment;

    /**
     * @return the employmentContractId
     */
    public Integer getEmploymentContractId() {
        return employmentContractId;
    }

    /**
     * @param employmentContractId the employmentContractId to set
     */
    public void setEmploymentContractId(Integer employmentContractId) {
        this.employmentContractId = employmentContractId;
    }

    /**
     * @return the baseSalaryValue
     */
    public Double getBaseSalaryValue() {
        return baseSalaryValue;
    }

    /**
     * @param baseSalaryValue the baseSalaryValue to set
     */
    public void setBaseSalaryValue(Double baseSalaryValue) {
        this.baseSalaryValue = baseSalaryValue;
    }

    /**
     * @return the isCurrent
     */
    public SN2Boolean getIsCurrent() {
        return isCurrent;
    }

    /**
     * @param isCurrent the isCurrent to set
     */
    public void setIsCurrent(SN2Boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    /**
     * @return the isFullSalary
     */
    public SN2Boolean getIsFullSalary() {
        return isFullSalary;
    }

    /**
     * @param isFullSalary the isFullSalary to set
     */
    public void setIsFullSalary(SN2Boolean isFullSalary) {
        this.isFullSalary = isFullSalary;
    }

    /**
     * @return the haveSurcharge
     */
    public SN2Boolean getHaveSurcharge() {
        return haveSurcharge;
    }

    /**
     * @param haveSurcharge the haveSurcharge to set
     */
    public void setHaveSurcharge(SN2Boolean haveSurcharge) {
        this.haveSurcharge = haveSurcharge;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the terminationDate
     */
    public Date getTerminationDate() {
        return terminationDate;
    }

    /**
     * @param terminationDate the terminationDate to set
     */
    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    /**
     * @return the termType
     */
    public ContractTermType getTermType() {
        return termType;
    }

    /**
     * @param termType the termType to set
     */
    public void setTermType(ContractTermType termType) {
        this.termType = termType;
    }

    /**
     * @return the mustReportWorkTime
     */
    public SN2Boolean getMustReportWorkTime() {
        return mustReportWorkTime;
    }

    /**
     * @param mustReportWorkTime the mustReportWorkTime to set
     */
    public void setMustReportWorkTime(SN2Boolean mustReportWorkTime) {
        this.mustReportWorkTime = mustReportWorkTime;
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
     * @return the employee
     */
    public GptEmployee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(GptEmployee employee) {
        this.employee = employee;
    }

    /**
     * @return the company
     */
    public MatCompany getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(MatCompany company) {
        this.company = company;
    }

    /**
     * @return the terminationReason
     */
    public GptContractTerminationReason getTerminationReason() {
        return terminationReason;
    }

    /**
     * @param terminationReason the terminationReason to set
     */
    public void setTerminationReason(GptContractTerminationReason terminationReason) {
        this.terminationReason = terminationReason;
    }

    /**
     * @return the appointment
     */
    public GptAppointment getAppointment() {
        return appointment;
    }

    /**
     * @param appointment the appointment to set
     */
    public void setAppointment(GptAppointment appointment) {
        this.appointment = appointment;
    }

}
