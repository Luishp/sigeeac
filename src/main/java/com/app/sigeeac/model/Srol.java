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
@Table(name = "SROL", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Srol.findAll", query = "SELECT s FROM Srol s")
    , @NamedQuery(name = "Srol.findByRolId", query = "SELECT s FROM Srol s WHERE s.rolId = :rolId")
    , @NamedQuery(name = "Srol.findByRolNombre", query = "SELECT s FROM Srol s WHERE s.rolNombre = :rolNombre")
    , @NamedQuery(name = "Srol.findByRolDescripcion", query = "SELECT s FROM Srol s WHERE s.rolDescripcion = :rolDescripcion")
    , @NamedQuery(name = "Srol.findByFecCrea", query = "SELECT s FROM Srol s WHERE s.fecCrea = :fecCrea")
    , @NamedQuery(name = "Srol.findByUsuCrea", query = "SELECT s FROM Srol s WHERE s.usuCrea = :usuCrea")
    , @NamedQuery(name = "Srol.findByFecModi", query = "SELECT s FROM Srol s WHERE s.fecModi = :fecModi")
    , @NamedQuery(name = "Srol.findByUsuModi", query = "SELECT s FROM Srol s WHERE s.usuModi = :usuModi")
    , @NamedQuery(name = "Srol.findByRegActivo", query = "SELECT s FROM Srol s WHERE s.regActivo = :regActivo")})
public class Srol implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_ID")
    public Integer rolId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ROL_NOMBRE")
    public String rolNombre;
    @Size(max = 4000)
    @Column(name = "ROL_DESCRIPCION")
    public String rolDescripcion;
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
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "perRolId", fetch = FetchType.LAZY)
    private Set<Spermiso> spermisoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrRolId", fetch = FetchType.LAZY)
    private Set<Susuario> susuarioSet;*/

    public Srol() {
    }

    public Srol(Integer rolId) {
        this.rolId = rolId;
    }

    public Srol(Integer rolId, String rolNombre, Date fecCrea, String usuCrea, short regActivo) {
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
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
    public Set<Spermiso> getSpermisoSet() {
        return spermisoSet;
    }

    public void setSpermisoSet(Set<Spermiso> spermisoSet) {
        this.spermisoSet = spermisoSet;
    }

    @XmlTransient
    public Set<Susuario> getSusuarioSet() {
        return susuarioSet;
    }

    public void setSusuarioSet(Set<Susuario> susuarioSet) {
        this.susuarioSet = susuarioSet;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Srol)) {
            return false;
        }
        Srol other = (Srol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.Srol[ rolId=" + rolId + " ]";
    }
    
}
