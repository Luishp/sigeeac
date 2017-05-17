/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luish
 */
@Entity
@Table(name = "RESTRINGE_MONTO_COMPRA", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RestringeMontoCompra.findAll", query = "SELECT r FROM RestringeMontoCompra r")
    , @NamedQuery(name = "RestringeMontoCompra.findByRmcId", query = "SELECT r FROM RestringeMontoCompra r WHERE r.rmcId = :rmcId")
    , @NamedQuery(name = "RestringeMontoCompra.findByRmcDescripcion", query = "SELECT r FROM RestringeMontoCompra r WHERE r.rmcDescripcion = :rmcDescripcion")
    , @NamedQuery(name = "RestringeMontoCompra.findByFecCrea", query = "SELECT r FROM RestringeMontoCompra r WHERE r.fecCrea = :fecCrea")
    , @NamedQuery(name = "RestringeMontoCompra.findByUsuCrea", query = "SELECT r FROM RestringeMontoCompra r WHERE r.usuCrea = :usuCrea")
    , @NamedQuery(name = "RestringeMontoCompra.findByFecModi", query = "SELECT r FROM RestringeMontoCompra r WHERE r.fecModi = :fecModi")
    , @NamedQuery(name = "RestringeMontoCompra.findByUsuModi", query = "SELECT r FROM RestringeMontoCompra r WHERE r.usuModi = :usuModi")
    , @NamedQuery(name = "RestringeMontoCompra.findByRegActivo", query = "SELECT r FROM RestringeMontoCompra r WHERE r.regActivo = :regActivo")})
public class RestringeMontoCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RMC_ID")
    private Integer rmcId;
    @Size(max = 4000)
    @Column(name = "RMC_DESCRIPCION")
    private String rmcDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCrea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "USU_CREA")
    private String usuCrea;
    @Column(name = "FEC_MODI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModi;
    @Size(max = 6)
    @Column(name = "USU_MODI")
    private String usuModi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REG_ACTIVO")
    private short regActivo;
    @JoinColumn(name = "RMC_EMP_ID", referencedColumnName = "EMP_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmpresaServicio rmcEmpId;
    @JoinColumn(name = "RMC_ING_ID", referencedColumnName = "ING_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InstitucionGubernamental rmcIngId;

    public RestringeMontoCompra() {
    }

    public RestringeMontoCompra(Integer rmcId) {
        this.rmcId = rmcId;
    }

    public RestringeMontoCompra(Integer rmcId, Date fecCrea, String usuCrea, short regActivo) {
        this.rmcId = rmcId;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getRmcId() {
        return rmcId;
    }

    public void setRmcId(Integer rmcId) {
        this.rmcId = rmcId;
    }

    public String getRmcDescripcion() {
        return rmcDescripcion;
    }

    public void setRmcDescripcion(String rmcDescripcion) {
        this.rmcDescripcion = rmcDescripcion;
    }

    public Date getFecCrea() {
        return fecCrea;
    }

    public void setFecCrea(Date fecCrea) {
        this.fecCrea = fecCrea;
    }

    public String getUsuCrea() {
        return usuCrea;
    }

    public void setUsuCrea(String usuCrea) {
        this.usuCrea = usuCrea;
    }

    public Date getFecModi() {
        return fecModi;
    }

    public void setFecModi(Date fecModi) {
        this.fecModi = fecModi;
    }

    public String getUsuModi() {
        return usuModi;
    }

    public void setUsuModi(String usuModi) {
        this.usuModi = usuModi;
    }

    public short getRegActivo() {
        return regActivo;
    }

    public void setRegActivo(short regActivo) {
        this.regActivo = regActivo;
    }

    public EmpresaServicio getRmcEmpId() {
        return rmcEmpId;
    }

    public void setRmcEmpId(EmpresaServicio rmcEmpId) {
        this.rmcEmpId = rmcEmpId;
    }

    public InstitucionGubernamental getRmcIngId() {
        return rmcIngId;
    }

    public void setRmcIngId(InstitucionGubernamental rmcIngId) {
        this.rmcIngId = rmcIngId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rmcId != null ? rmcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RestringeMontoCompra)) {
            return false;
        }
        RestringeMontoCompra other = (RestringeMontoCompra) object;
        if ((this.rmcId == null && other.rmcId != null) || (this.rmcId != null && !this.rmcId.equals(other.rmcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.RestringeMontoCompra[ rmcId=" + rmcId + " ]";
    }
    
}
