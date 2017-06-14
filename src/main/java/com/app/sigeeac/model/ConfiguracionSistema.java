/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luish
 */
@Entity
@Table(name = "CONFIGURACION_SISTEMA", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfiguracionSistema.findAll", query = "SELECT c FROM ConfiguracionSistema c")
    , @NamedQuery(name = "ConfiguracionSistema.findByCfgId", query = "SELECT c FROM ConfiguracionSistema c WHERE c.cfgId = :cfgId")
    , @NamedQuery(name = "ConfiguracionSistema.findByCfgNombre", query = "SELECT c FROM ConfiguracionSistema c WHERE c.cfgNombre = :cfgNombre")
    , @NamedQuery(name = "ConfiguracionSistema.findByCfgValor", query = "SELECT c FROM ConfiguracionSistema c WHERE c.cfgValor = :cfgValor")
    , @NamedQuery(name = "ConfiguracionSistema.findByCfgDescripcion", query = "SELECT c FROM ConfiguracionSistema c WHERE c.cfgDescripcion = :cfgDescripcion")
    , @NamedQuery(name = "ConfiguracionSistema.findByFecCrea", query = "SELECT c FROM ConfiguracionSistema c WHERE c.fecCrea = :fecCrea")
    , @NamedQuery(name = "ConfiguracionSistema.findByUsuCrea", query = "SELECT c FROM ConfiguracionSistema c WHERE c.usuCrea = :usuCrea")
    , @NamedQuery(name = "ConfiguracionSistema.findByFecModi", query = "SELECT c FROM ConfiguracionSistema c WHERE c.fecModi = :fecModi")
    , @NamedQuery(name = "ConfiguracionSistema.findByUsuModi", query = "SELECT c FROM ConfiguracionSistema c WHERE c.usuModi = :usuModi")
    , @NamedQuery(name = "ConfiguracionSistema.findByRegActivo", query = "SELECT c FROM ConfiguracionSistema c WHERE c.regActivo = :regActivo")})
public class ConfiguracionSistema implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CFG_ID")
    public Integer cfgId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "CFG_NOMBRE")
    public String cfgNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "CFG_VALOR")
    public String cfgValor;
    @Size(max = 4000)
    @Column(name = "CFG_DESCRIPCION")
    public String cfgDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    public Date fecCrea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "USU_CREA")
    public String usuCrea;
    @Column(name = "FEC_MODI")
    @Temporal(TemporalType.TIMESTAMP)
    public Date fecModi;
    @Size(max = 6)
    @Column(name = "USU_MODI")
    public String usuModi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REG_ACTIVO")
    public short regActivo;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "incCfgId", fetch = FetchType.LAZY)
    public Set<InstitucionConfiguracion> institucionConfiguracionSet;*/

    public ConfiguracionSistema() {
    }

    public ConfiguracionSistema(Integer cfgId) {
        this.cfgId = cfgId;
    }

    public ConfiguracionSistema(Integer cfgId, String cfgNombre, String cfgValor, Date fecCrea, String usuCrea, short regActivo) {
        this.cfgId = cfgId;
        this.cfgNombre = cfgNombre;
        this.cfgValor = cfgValor;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getCfgId() {
        return cfgId;
    }

    public void setCfgId(Integer cfgId) {
        this.cfgId = cfgId;
    }

    public String getCfgNombre() {
        return cfgNombre;
    }

    public void setCfgNombre(String cfgNombre) {
        this.cfgNombre = cfgNombre;
    }

    public String getCfgValor() {
        return cfgValor;
    }

    public void setCfgValor(String cfgValor) {
        this.cfgValor = cfgValor;
    }

    public String getCfgDescripcion() {
        return cfgDescripcion;
    }

    public void setCfgDescripcion(String cfgDescripcion) {
        this.cfgDescripcion = cfgDescripcion;
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

    /*@XmlTransient
    public Set<InstitucionConfiguracion> getInstitucionConfiguracionSet() {
        return institucionConfiguracionSet;
    }

    public void setInstitucionConfiguracionSet(Set<InstitucionConfiguracion> institucionConfiguracionSet) {
        this.institucionConfiguracionSet = institucionConfiguracionSet;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cfgId != null ? cfgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfiguracionSistema)) {
            return false;
        }
        ConfiguracionSistema other = (ConfiguracionSistema) object;
        if ((this.cfgId == null && other.cfgId != null) || (this.cfgId != null && !this.cfgId.equals(other.cfgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.ConfiguracionSistema[ cfgId=" + cfgId + " ]";
    }
    
}
