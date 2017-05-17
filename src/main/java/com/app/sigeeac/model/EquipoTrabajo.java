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
@Table(name = "EQUIPO_TRABAJO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoTrabajo.findAll", query = "SELECT e FROM EquipoTrabajo e")
    , @NamedQuery(name = "EquipoTrabajo.findByEqtId", query = "SELECT e FROM EquipoTrabajo e WHERE e.eqtId = :eqtId")
    , @NamedQuery(name = "EquipoTrabajo.findByEqtNombre", query = "SELECT e FROM EquipoTrabajo e WHERE e.eqtNombre = :eqtNombre")
    , @NamedQuery(name = "EquipoTrabajo.findByEqtDescripcion", query = "SELECT e FROM EquipoTrabajo e WHERE e.eqtDescripcion = :eqtDescripcion")
    , @NamedQuery(name = "EquipoTrabajo.findByFecCrea", query = "SELECT e FROM EquipoTrabajo e WHERE e.fecCrea = :fecCrea")
    , @NamedQuery(name = "EquipoTrabajo.findByUsuCrea", query = "SELECT e FROM EquipoTrabajo e WHERE e.usuCrea = :usuCrea")
    , @NamedQuery(name = "EquipoTrabajo.findByFecModi", query = "SELECT e FROM EquipoTrabajo e WHERE e.fecModi = :fecModi")
    , @NamedQuery(name = "EquipoTrabajo.findByUsuModi", query = "SELECT e FROM EquipoTrabajo e WHERE e.usuModi = :usuModi")
    , @NamedQuery(name = "EquipoTrabajo.findByRegActivo", query = "SELECT e FROM EquipoTrabajo e WHERE e.regActivo = :regActivo")})
public class EquipoTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EQT_ID")
    private Integer eqtId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "EQT_NOMBRE")
    private String eqtNombre;
    @Size(max = 4000)
    @Column(name = "EQT_DESCRIPCION")
    private String eqtDescripcion;
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
    @JoinColumn(name = "EQT_MTT_ID", referencedColumnName = "MTT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mantenimiento eqtMttId;
    @JoinColumn(name = "EQT_TEC_ID", referencedColumnName = "TEC_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tecnico eqtTecId;

    public EquipoTrabajo() {
    }

    public EquipoTrabajo(Integer eqtId) {
        this.eqtId = eqtId;
    }

    public EquipoTrabajo(Integer eqtId, String eqtNombre, Date fecCrea, String usuCrea, short regActivo) {
        this.eqtId = eqtId;
        this.eqtNombre = eqtNombre;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getEqtId() {
        return eqtId;
    }

    public void setEqtId(Integer eqtId) {
        this.eqtId = eqtId;
    }

    public String getEqtNombre() {
        return eqtNombre;
    }

    public void setEqtNombre(String eqtNombre) {
        this.eqtNombre = eqtNombre;
    }

    public String getEqtDescripcion() {
        return eqtDescripcion;
    }

    public void setEqtDescripcion(String eqtDescripcion) {
        this.eqtDescripcion = eqtDescripcion;
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

    public Mantenimiento getEqtMttId() {
        return eqtMttId;
    }

    public void setEqtMttId(Mantenimiento eqtMttId) {
        this.eqtMttId = eqtMttId;
    }

    public Tecnico getEqtTecId() {
        return eqtTecId;
    }

    public void setEqtTecId(Tecnico eqtTecId) {
        this.eqtTecId = eqtTecId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqtId != null ? eqtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoTrabajo)) {
            return false;
        }
        EquipoTrabajo other = (EquipoTrabajo) object;
        if ((this.eqtId == null && other.eqtId != null) || (this.eqtId != null && !this.eqtId.equals(other.eqtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.EquipoTrabajo[ eqtId=" + eqtId + " ]";
    }
    
}
