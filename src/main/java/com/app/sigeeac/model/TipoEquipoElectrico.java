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
@Table(name = "TIPO_EQUIPO_ELECTRICO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEquipoElectrico.findAll", query = "SELECT t FROM TipoEquipoElectrico t")
    , @NamedQuery(name = "TipoEquipoElectrico.findByTeqId", query = "SELECT t FROM TipoEquipoElectrico t WHERE t.teqId = :teqId")
    , @NamedQuery(name = "TipoEquipoElectrico.findByTeqNombre", query = "SELECT t FROM TipoEquipoElectrico t WHERE t.teqNombre = :teqNombre")
    , @NamedQuery(name = "TipoEquipoElectrico.findByTeqDescripcion", query = "SELECT t FROM TipoEquipoElectrico t WHERE t.teqDescripcion = :teqDescripcion")
    , @NamedQuery(name = "TipoEquipoElectrico.findByFecCrea", query = "SELECT t FROM TipoEquipoElectrico t WHERE t.fecCrea = :fecCrea")
    , @NamedQuery(name = "TipoEquipoElectrico.findByUsuCrea", query = "SELECT t FROM TipoEquipoElectrico t WHERE t.usuCrea = :usuCrea")
    , @NamedQuery(name = "TipoEquipoElectrico.findByFecModi", query = "SELECT t FROM TipoEquipoElectrico t WHERE t.fecModi = :fecModi")
    , @NamedQuery(name = "TipoEquipoElectrico.findByUsuModi", query = "SELECT t FROM TipoEquipoElectrico t WHERE t.usuModi = :usuModi")
    , @NamedQuery(name = "TipoEquipoElectrico.findByRegActivo", query = "SELECT t FROM TipoEquipoElectrico t WHERE t.regActivo = :regActivo")})
public class TipoEquipoElectrico implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEQ_ID")
    private Integer teqId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "TEQ_NOMBRE")
    private String teqNombre;
    @Size(max = 4000)
    @Column(name = "TEQ_DESCRIPCION")
    private String teqDescripcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solTeqId", fetch = FetchType.LAZY)
    private Set<SolicitudCompra> solicitudCompraSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cteTeqId", fetch = FetchType.LAZY)
    private Set<Caracteristica> caracteristicaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eqeTeqId", fetch = FetchType.LAZY)
    private Set<EquipoElectrico> equipoElectricoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alrTeqId", fetch = FetchType.LAZY)
    private Set<AlertasMantenimiento> alertasMantenimientoSet;

    public TipoEquipoElectrico() {
    }

    public TipoEquipoElectrico(Integer teqId) {
        this.teqId = teqId;
    }

    public TipoEquipoElectrico(Integer teqId, String teqNombre, Date fecCrea, String usuCrea, short regActivo) {
        this.teqId = teqId;
        this.teqNombre = teqNombre;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getTeqId() {
        return teqId;
    }

    public void setTeqId(Integer teqId) {
        this.teqId = teqId;
    }

    public String getTeqNombre() {
        return teqNombre;
    }

    public void setTeqNombre(String teqNombre) {
        this.teqNombre = teqNombre;
    }

    public String getTeqDescripcion() {
        return teqDescripcion;
    }

    public void setTeqDescripcion(String teqDescripcion) {
        this.teqDescripcion = teqDescripcion;
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

    @XmlTransient
    public Set<SolicitudCompra> getSolicitudCompraSet() {
        return solicitudCompraSet;
    }

    public void setSolicitudCompraSet(Set<SolicitudCompra> solicitudCompraSet) {
        this.solicitudCompraSet = solicitudCompraSet;
    }

    @XmlTransient
    public Set<Caracteristica> getCaracteristicaSet() {
        return caracteristicaSet;
    }

    public void setCaracteristicaSet(Set<Caracteristica> caracteristicaSet) {
        this.caracteristicaSet = caracteristicaSet;
    }

    @XmlTransient
    public Set<EquipoElectrico> getEquipoElectricoSet() {
        return equipoElectricoSet;
    }

    public void setEquipoElectricoSet(Set<EquipoElectrico> equipoElectricoSet) {
        this.equipoElectricoSet = equipoElectricoSet;
    }

    @XmlTransient
    public Set<AlertasMantenimiento> getAlertasMantenimientoSet() {
        return alertasMantenimientoSet;
    }

    public void setAlertasMantenimientoSet(Set<AlertasMantenimiento> alertasMantenimientoSet) {
        this.alertasMantenimientoSet = alertasMantenimientoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teqId != null ? teqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEquipoElectrico)) {
            return false;
        }
        TipoEquipoElectrico other = (TipoEquipoElectrico) object;
        if ((this.teqId == null && other.teqId != null) || (this.teqId != null && !this.teqId.equals(other.teqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.TipoEquipoElectrico[ teqId=" + teqId + " ]";
    }
    
}
