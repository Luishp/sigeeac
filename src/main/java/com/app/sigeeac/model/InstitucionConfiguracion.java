/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "INSTITUCION_CONFIGURACION", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitucionConfiguracion.findAll", query = "SELECT i FROM InstitucionConfiguracion i")
    , @NamedQuery(name = "InstitucionConfiguracion.findByIncId", query = "SELECT i FROM InstitucionConfiguracion i WHERE i.incId = :incId")
    , @NamedQuery(name = "InstitucionConfiguracion.findByIncDescripcion", query = "SELECT i FROM InstitucionConfiguracion i WHERE i.incDescripcion = :incDescripcion")
    , @NamedQuery(name = "InstitucionConfiguracion.findByFecCrea", query = "SELECT i FROM InstitucionConfiguracion i WHERE i.fecCrea = :fecCrea")
    , @NamedQuery(name = "InstitucionConfiguracion.findByUsuCrea", query = "SELECT i FROM InstitucionConfiguracion i WHERE i.usuCrea = :usuCrea")
    , @NamedQuery(name = "InstitucionConfiguracion.findByFecModi", query = "SELECT i FROM InstitucionConfiguracion i WHERE i.fecModi = :fecModi")
    , @NamedQuery(name = "InstitucionConfiguracion.findByUsuModi", query = "SELECT i FROM InstitucionConfiguracion i WHERE i.usuModi = :usuModi")
    , @NamedQuery(name = "InstitucionConfiguracion.findByRegActivo", query = "SELECT i FROM InstitucionConfiguracion i WHERE i.regActivo = :regActivo")})
public class InstitucionConfiguracion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INC_ID")
    private Integer incId;
    @Column(name = "INC_DESCRIPCION")
    private BigInteger incDescripcion;
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
    @JoinColumn(name = "INC_CFG_ID", referencedColumnName = "CFG_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ConfiguracionSistema incCfgId;
    @JoinColumn(name = "INC_ING_ID", referencedColumnName = "ING_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InstitucionGubernamental incIngId;

    public InstitucionConfiguracion() {
    }

    public InstitucionConfiguracion(Integer incId) {
        this.incId = incId;
    }

    public InstitucionConfiguracion(Integer incId, Date fecCrea, String usuCrea, short regActivo) {
        this.incId = incId;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getIncId() {
        return incId;
    }

    public void setIncId(Integer incId) {
        this.incId = incId;
    }

    public BigInteger getIncDescripcion() {
        return incDescripcion;
    }

    public void setIncDescripcion(BigInteger incDescripcion) {
        this.incDescripcion = incDescripcion;
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

    public ConfiguracionSistema getIncCfgId() {
        return incCfgId;
    }

    public void setIncCfgId(ConfiguracionSistema incCfgId) {
        this.incCfgId = incCfgId;
    }

    public InstitucionGubernamental getIncIngId() {
        return incIngId;
    }

    public void setIncIngId(InstitucionGubernamental incIngId) {
        this.incIngId = incIngId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incId != null ? incId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitucionConfiguracion)) {
            return false;
        }
        InstitucionConfiguracion other = (InstitucionConfiguracion) object;
        if ((this.incId == null && other.incId != null) || (this.incId != null && !this.incId.equals(other.incId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.InstitucionConfiguracion[ incId=" + incId + " ]";
    }
    
}
