/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ALERTAS_MANTENIMIENTO", catalog = "", schema = "GEEAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlertasMantenimiento.findAll", query = "SELECT a FROM AlertasMantenimiento a")
    , @NamedQuery(name = "AlertasMantenimiento.findByAlrId", query = "SELECT a FROM AlertasMantenimiento a WHERE a.alrId = :alrId")
    , @NamedQuery(name = "AlertasMantenimiento.findByAlrNombre", query = "SELECT a FROM AlertasMantenimiento a WHERE a.alrNombre = :alrNombre")
    , @NamedQuery(name = "AlertasMantenimiento.findByAlrValor", query = "SELECT a FROM AlertasMantenimiento a WHERE a.alrValor = :alrValor")
    , @NamedQuery(name = "AlertasMantenimiento.findByAlrDescripcion", query = "SELECT a FROM AlertasMantenimiento a WHERE a.alrDescripcion = :alrDescripcion")
    , @NamedQuery(name = "AlertasMantenimiento.findByFecCrea", query = "SELECT a FROM AlertasMantenimiento a WHERE a.fecCrea = :fecCrea")
    , @NamedQuery(name = "AlertasMantenimiento.findByUsuCrea", query = "SELECT a FROM AlertasMantenimiento a WHERE a.usuCrea = :usuCrea")
    , @NamedQuery(name = "AlertasMantenimiento.findByFecModi", query = "SELECT a FROM AlertasMantenimiento a WHERE a.fecModi = :fecModi")
    , @NamedQuery(name = "AlertasMantenimiento.findByUsuModi", query = "SELECT a FROM AlertasMantenimiento a WHERE a.usuModi = :usuModi")
    , @NamedQuery(name = "AlertasMantenimiento.findByRegActivo", query = "SELECT a FROM AlertasMantenimiento a WHERE a.regActivo = :regActivo")})
public class AlertasMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALR_ID")
    private Integer alrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ALR_NOMBRE")
    private String alrNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ALR_VALOR")
    private String alrValor;
    @Size(max = 4000)
    @Column(name = "ALR_DESCRIPCION")
    private String alrDescripcion;
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
    @JoinColumn(name = "ALR_ING_ID", referencedColumnName = "ING_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InstitucionGubernamental alrIngId;
    @JoinColumn(name = "ALR_TEQ_ID", referencedColumnName = "TEQ_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoEquipoElectrico alrTeqId;

    public AlertasMantenimiento() {
    }

    public AlertasMantenimiento(Integer alrId) {
        this.alrId = alrId;
    }

    public AlertasMantenimiento(Integer alrId, String alrNombre, String alrValor, Date fecCrea, String usuCrea, short regActivo) {
        this.alrId = alrId;
        this.alrNombre = alrNombre;
        this.alrValor = alrValor;
        this.fecCrea = fecCrea;
        this.usuCrea = usuCrea;
        this.regActivo = regActivo;
    }

    public Integer getAlrId() {
        return alrId;
    }

    public void setAlrId(Integer alrId) {
        this.alrId = alrId;
    }

    public String getAlrNombre() {
        return alrNombre;
    }

    public void setAlrNombre(String alrNombre) {
        this.alrNombre = alrNombre;
    }

    public String getAlrValor() {
        return alrValor;
    }

    public void setAlrValor(String alrValor) {
        this.alrValor = alrValor;
    }

    public String getAlrDescripcion() {
        return alrDescripcion;
    }

    public void setAlrDescripcion(String alrDescripcion) {
        this.alrDescripcion = alrDescripcion;
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

    public InstitucionGubernamental getAlrIngId() {
        return alrIngId;
    }

    public void setAlrIngId(InstitucionGubernamental alrIngId) {
        this.alrIngId = alrIngId;
    }

    public TipoEquipoElectrico getAlrTeqId() {
        return alrTeqId;
    }

    public void setAlrTeqId(TipoEquipoElectrico alrTeqId) {
        this.alrTeqId = alrTeqId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alrId != null ? alrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlertasMantenimiento)) {
            return false;
        }
        AlertasMantenimiento other = (AlertasMantenimiento) object;
        if ((this.alrId == null && other.alrId != null) || (this.alrId != null && !this.alrId.equals(other.alrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sigeeac.model.AlertasMantenimiento[ alrId=" + alrId + " ]";
    }
    
}
