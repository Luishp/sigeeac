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
@Table(name = "TIPO_MANTENIMIENTO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMantenimiento.findAll", query = "SELECT t FROM TipoMantenimiento t")
    , @NamedQuery(name = "TipoMantenimiento.findByTmtId", query = "SELECT t FROM TipoMantenimiento t WHERE t.tmtId = :tmtId")
    , @NamedQuery(name = "TipoMantenimiento.findByTmtNombre", query = "SELECT t FROM TipoMantenimiento t WHERE t.tmtNombre = :tmtNombre")
    , @NamedQuery(name = "TipoMantenimiento.findByTmtDescripcion", query = "SELECT t FROM TipoMantenimiento t WHERE t.tmtDescripcion = :tmtDescripcion")
    , @NamedQuery(name = "TipoMantenimiento.findByFecCrea", query = "SELECT t FROM TipoMantenimiento t WHERE t.fecCrea = :fecCrea")
    , @NamedQuery(name = "TipoMantenimiento.findByUsuCrea", query = "SELECT t FROM TipoMantenimiento t WHERE t.usuCrea = :usuCrea")
    , @NamedQuery(name = "TipoMantenimiento.findByFecModi", query = "SELECT t FROM TipoMantenimiento t WHERE t.fecModi = :fecModi")
    , @NamedQuery(name = "TipoMantenimiento.findByUsuModi", query = "SELECT t FROM TipoMantenimiento t WHERE t.usuModi = :usuModi")
    , @NamedQuery(name = "TipoMantenimiento.findByRegActivo", query = "SELECT t FROM TipoMantenimiento t WHERE t.regActivo = :regActivo")})
public class TipoMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TMT_ID")
    public Integer tmtId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "TMT_NOMBRE")
    public String tmtNombre;
    @Size(max = 4000)
    @Column(name = "TMT_DESCRIPCION")
    public String tmtDescripcion;
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
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "mttTmtId", fetch = FetchType.LAZY)
    private Set<Mantenimiento> mantenimientoSet;*/

    public TipoMantenimiento() {
    }

    public TipoMantenimiento(Integer tmtId) {
        this.tmtId = tmtId;
    }

    public TipoMantenimiento(Integer tmtId, String tmtNombre, Date fecCrea, String usuCrea, short regActivo) {
        this.tmtId = tmtId;
        this.tmtNombre = tmtNombre;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getTmtId() {
        return tmtId;
    }

    public void setTmtId(Integer tmtId) {
        this.tmtId = tmtId;
    }

    public String getTmtNombre() {
        return tmtNombre;
    }

    public void setTmtNombre(String tmtNombre) {
        this.tmtNombre = tmtNombre;
    }

    public String getTmtDescripcion() {
        return tmtDescripcion;
    }

    public void setTmtDescripcion(String tmtDescripcion) {
        this.tmtDescripcion = tmtDescripcion;
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
    public Set<Mantenimiento> getMantenimientoSet() {
        return mantenimientoSet;
    }

    public void setMantenimientoSet(Set<Mantenimiento> mantenimientoSet) {
        this.mantenimientoSet = mantenimientoSet;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmtId != null ? tmtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMantenimiento)) {
            return false;
        }
        TipoMantenimiento other = (TipoMantenimiento) object;
        if ((this.tmtId == null && other.tmtId != null) || (this.tmtId != null && !this.tmtId.equals(other.tmtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.TipoMantenimiento[ tmtId=" + tmtId + " ]";
    }
    
}
